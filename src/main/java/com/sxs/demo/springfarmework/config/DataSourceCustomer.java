package com.sxs.demo.springfarmework.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName: TransactionCustomer
 * @Description: 自定义datasource
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 18:03
 * @Version: 1.0
 */
@Configuration
public class DataSourceCustomer {


    @Bean
    public DruidDataSource datasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setInitialSize(20);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(5);
        dataSource.setMaxWait(60000);
        dataSource.setDriverClassName("com.mysql.jdbc.driver");
        return dataSource;
    }
}
