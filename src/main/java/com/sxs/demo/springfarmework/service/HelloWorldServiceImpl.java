package com.sxs.demo.springfarmework.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @ClassName: HelloWorldServiceImpl
 * @Description: 数据库原子操作实现类
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 18:25
 * @Version: 1.0
 */
@Component
public class HelloWorldServiceImpl {

    private final Logger logger = Logger.getLogger(HelloWorldServiceImpl.class);

    @Transactional
    public String transaction(String flag){

        // 执行数据库原子操作
        logger.info("执行第一个原子操作...");

        // 执行数据库原子操作
        logger.info("执行第二个原子操作...");

        if ("true".equals(flag)){
            // 执行数据库原子操作
            logger.info("执行第三个原子操作...");
            return "successful";
        }else {
            throw new RuntimeException("事务原子操作失败，执行回滚");
        }
    }
}
