package com.sxs.demo.springfarmework.log;

import com.sxs.demo.springfarmework.service.HelloWorldServiceImpl;
import org.apache.log4j.Logger;

/**
 * @ClassName: LoggerTest
 * @Description: 分析系统加载log4j过程。可自定义实现
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 17:35
 * @Version: 1.0
 */
public class LoggerTest {


    private final static Logger logger = Logger.getLogger(LoggerTest.class);
    public static void main(String[] args)
    {
        // 测试日志打印结果
        logger.info("......info");
        logger.debug("......debug");
        logger.warn("......warn");
        logger.error("......error");
        logger.trace("......trace");
    }

}
