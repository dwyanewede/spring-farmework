package com.sxs.demo.springfarmework.handler;

import com.alibaba.fastjson.JSON;
import com.sxs.demo.springfarmework.domain.Log;
import com.sxs.demo.springfarmework.log.LoggerTest;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

/**
 * @ClassName: LogHandlerInterceptor
 * @Description: 日志统一处理类
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 20:11
 * @Version: 1.0
 */
@Component
@Aspect
public class LogHandlerInterceptor {
    private final Logger logger = Logger.getLogger(LogHandlerInterceptor.class);

    @Pointcut("execution(* com.sxs.demo.springfarmework.controller..*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            long costTime = end - start;

            printLog(joinPoint, result, costTime);

        }

        return result;
    }

    /**
     * 打印日志
     * @param joinPoint   连接点
     * @param result      方法调用返回结果
     * @param costTime 方法调用花费时间
     */
    private void printLog(ProceedingJoinPoint joinPoint, Object result, long costTime) {
        Log log = getLog(joinPoint);
        if (null != log) {
            log.setThreadId(String.valueOf(Thread.currentThread().getId()));
            log.setResult(JSON.toJSONString(result));
            log.setCostTime(costTime);
            logger.info(log.toString());
        }
    }

    /**
     * 获取请求对应的类名，方法名，参数类型，参数值
     * @param joinPoint
     * @return
     */
    private Log getLog(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        Log log = new Log();
        log.setClassName(className);
        log.setMethodName(methodName);
        log.setArguments(args);
        return log;
    }
}
