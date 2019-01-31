package com.sxs.demo.springfarmework.handler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @ClassName: ExceptionHandler
 * @Description: 异常处理拦截器，
 * 同理可在com.sxs.demo.springfarmework.config.WebMvcConfig#addInterceptors实现
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 18:44
 * @Version: 1.0
 */
@ControllerAdvice(basePackages = "com.sxs.demo.springfarmework.controller")
public class ExceptionHandler {

    private final Logger logger = Logger.getLogger(ExceptionHandler.class);


    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public String exceptionHandler(RuntimeException exception){
        logger.error("系统调用异常,异常信息：[{}]",exception.getCause());
        return "fail";
    }
}
