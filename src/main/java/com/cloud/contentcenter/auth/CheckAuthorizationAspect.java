package com.cloud.contentcenter.auth;

import com.cloud.contentcenter.util.JwtOperator;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author 王峥
 * @date 2020/7/3 4:27 下午
 */
@Aspect
@Component
public class CheckAuthorizationAspect {
    @Resource
    private JwtOperator jwtOperator;

    @Around("@annotation(com.cloud.contentcenter.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        try {
            CheckToken();
        } catch (Throwable throwable) {
            throw new SecurityException("Token不合法!",throwable);
        }
        return point.proceed();

    }

    private void CheckToken() {
        try {
            //1.从header里面获取token
            HttpServletRequest request = getHttpServletRequest();
            String token = request.getHeader("X-Token");
            //2.校验token是否合法如果不合法,直接抛异常,合法就放行.
            Boolean isValidate = jwtOperator.validateToken(token);
            if (!isValidate) {
                throw new SecurityException("Token不合法");
            }
            //3.如果校验成功就把信息设置到request的attribute里面
            Claims claimsFromToken = jwtOperator.getClaimsFromToken(token);
            request.setAttribute("id",claimsFromToken.get("id"));
            request.setAttribute("wxNickname",claimsFromToken.get("wxNickname"));
            request.setAttribute("role",claimsFromToken.get("role"));
        } catch (SecurityException e) {
            throw new SecurityException("Token不合法!");
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }

    @Around("@annotation(com.cloud.contentcenter.auth.CheckAuthorization)")
    public Object checkAuthorization(ProceedingJoinPoint point) throws Throwable {
//验证token是否合法
        try {
        this.CheckToken();
        HttpServletRequest httpServletRequest = this.getHttpServletRequest();
        String role = (String)httpServletRequest.getAttribute("role");
         MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        CheckAuthorization  annotation = method.getAnnotation(CheckAuthorization.class);
        String value = annotation.value();
        if (!Objects.equals(role, value)) {
            throw new SecurityException("用户无权访问!");
        }

        } catch (Throwable throwable) {
            throw new SecurityException("用户无权访问!", throwable);
        }
        return point.proceed();

    }
}
