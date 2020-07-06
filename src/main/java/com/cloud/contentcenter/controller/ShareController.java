package com.cloud.contentcenter.controller;

import com.cloud.contentcenter.auth.CheckLogin;
import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.model.Share;
import com.cloud.contentcenter.service.content.ShareService;
import com.cloud.contentcenter.util.JwtOperator;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 王峥
 * @date 2020/6/23 5:33 下午
 */
@RestController
@RequestMapping("/shares")
public class ShareController {
    @Resource
    private ShareService shareService;
    @Resource
    private JwtOperator jwtOperator;

    @GetMapping("/{id}")
    @CheckLogin
    public ShareDTO findByid(@PathVariable Integer id) {
        return shareService.findByid(id);
    }
    @GetMapping("/q")
    public PageInfo<Share> q(@RequestParam(required = false) String title,
                             @RequestParam(required = false,defaultValue = "1")Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             @RequestHeader(value = "X-Token",required = false) String token) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        Integer userId = null;
        if (StringUtils.isNotBlank(token)) {
            Claims claimsFromToken = jwtOperator.getClaimsFromToken(token);
            userId = (Integer) claimsFromToken.get("id");
        }


        return this.shareService.q(title,pageNo,pageSize,userId);
    }
    @GetMapping("/exchange/{id}")
    @CheckLogin
    public Share exchangeById(@PathVariable Integer id, HttpServletRequest request) {
        return this.shareService.exchangeById(id, request);
    }
 /*   public ShareDTO findByid(@PathVariable Integer id, @RequestHeader(value = "X-Token",required = false) String token) {
        return shareService.findByid(id,token);
    }*/
}
