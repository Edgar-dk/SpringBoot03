package com.sias.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Edgar
 * @create 2022-03-04 18:55
 * @faction: 自定义处理错误信息
 */
@Slf4j
@ControllerAdvice//处理错误信息的注解
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
    public String handleArithException(Exception e){
        log.info("异常是{}" ,e);//把过来的异常信息，打印出来
        return "login";
    }
}
