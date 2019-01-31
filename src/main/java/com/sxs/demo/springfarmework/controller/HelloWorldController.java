package com.sxs.demo.springfarmework.controller;

import com.sxs.demo.springfarmework.annotation.AspectAnnotation;
import com.sxs.demo.springfarmework.handler.LogHandlerInterceptor;
import com.sxs.demo.springfarmework.service.HelloWorldServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: LoggerTest
 * @Description: 分析spring在什么时候加载log4j
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 15:53
 * @Version: 1.0
 */
@Controller
public class HelloWorldController {

    private final Logger logger = Logger.getLogger(HelloWorldController.class);

    private final HelloWorldServiceImpl helloWorldService;
    @Autowired
    public HelloWorldController(HelloWorldServiceImpl helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping("/hello")
    public String index(Model model) {
//        model.addAttribute("acceptLanguage",acceptLanguage);
//        model.addAttribute("jsessionId",jsessionId);
//        model.addAttribute("message","Hello,World");
        logger.info("请求/Hello到达...");
        return "index";
    }

    /**
     * 非必输参数，根据flag真假模拟测试事务的成功与否
     * @param flag
     * @return
     */
    @AspectAnnotation
    @RequestMapping("/transaction")
    public String transaction(@RequestParam(required = false) String flag) {
        logger.info("请求/transaction到达...");
        String msg = helloWorldService.transaction(flag);
        return msg;
    }

}
