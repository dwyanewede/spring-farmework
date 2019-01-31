package com.sxs.demo.springfarmework.domain;

import java.util.Arrays;

/**
 * @ClassName: Log
 * @Description: Log实体
 * @Author: 尚先生
 * @CreateDate: 2019/1/30 20:19
 * @Version: 1.0
 */
//@Data
public class Log {

    private String threadId;

    private String className;

    private String methodName;

    private Object[] arguments;

    private String result;

    private Long costTime;

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "threadId='" + threadId + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", arguments=" + Arrays.toString(arguments) +
                ", result='" + result + '\'' +
                ", costTime=" + costTime +
                '}';
    }
}
