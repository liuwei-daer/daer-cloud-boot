package com.daer.cloud.common.log.annotation;

import java.lang.annotation.*;

/**
 * 方法描述
 * @author liuwei
 * @date 2020-12-07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {
    /**
     * 描述
     * @return {String}
     */
    String value() default "";

    /**
     * 是否开启
     * @return {boolean}
     */
    boolean isLogParams() default true;
}