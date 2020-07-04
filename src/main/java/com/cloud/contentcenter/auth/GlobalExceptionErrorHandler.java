package com.cloud.contentcenter.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 王峥
 * @date 2020/7/3 8:34 下午
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionErrorHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorBody> error(SecurityException e) {
        log.info("发生了SecurityException异常",e);
       return new ResponseEntity<>(
               ErrorBody.builder()
                       .body(e.getMessage())
                       .status(HttpStatus.UNAUTHORIZED.value())
                       .build(),
               HttpStatus.UNAUTHORIZED
       );

    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ErrorBody{
    private String body;
    private int status;
}
