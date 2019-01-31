package com.sxs.demo.springfarmework.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @ClassName: AspectAnnotation
 * @Description: 自定义切面注解
 * @Author: 尚先生
 * @CreateDate: 2019/1/31 13:07
 * @Version: 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface AspectAnnotation {

    /** 添加注解描述信息 **/
    String value() default "";

    /** 判断注解是否生效，默认生效 **/
    boolean flag() default true;
}
