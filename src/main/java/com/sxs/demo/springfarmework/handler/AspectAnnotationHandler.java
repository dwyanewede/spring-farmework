package com.sxs.demo.springfarmework.handler;

import com.sxs.demo.springfarmework.annotation.AspectAnnotation;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName: AspectAnnotationHandler
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/31 13:10
 * @Version: 1.0
 */
public class AspectAnnotationHandler implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(AspectAnnotationHandler.class);
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //此处可做鉴权，或者是准入校验
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            // 获取请求路径
            StringBuffer requestURL = request.getRequestURL();
            //本次所做操作是判断是否有自定义注解AspectAnnotation
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法名
            Method method = handlerMethod.getMethod();
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            AspectAnnotation annotation = method.getAnnotation(AspectAnnotation.class);
            if (null != annotation) {
                // 获取参数 map
                Map<String, String[]> map = request.getParameterMap();
                if (null != map) {
                    List<String> listValue = new ArrayList<>();
                    List<String> listkey = new ArrayList<>();

                    for (Map.Entry<String, String[]> entry : map.entrySet()) {
                        String key = entry.getKey();
                        listkey.add(key);
                        String[] value = entry.getValue();
                        listValue = Arrays.asList(value);
                    }

                    logger.info("请求URL: " + requestURL + " 请求方法：" + method + " 请求参数名: "
                            + listkey.toString() + " 请求参数: " + listValue.toString());
                }else {
                    logger.info("请求URL: " + requestURL + " 请求方法：" + method);
                }
            }
        }
        return true;
    }

}
