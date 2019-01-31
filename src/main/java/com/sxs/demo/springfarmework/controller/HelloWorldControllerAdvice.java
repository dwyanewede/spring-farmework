package com.sxs.demo.springfarmework.controller;

import com.sxs.demo.springfarmework.handler.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: LoggerTest
 * @Description: 分析spring在什么时候加载log4j
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 16:33
 * @Version: 1.0
 */
//@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,World";
    }

//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<String> onException(Throwable throwable) {
//        return ResponseEntity.ok(throwable.getMessage());
//    }

}
