package com.hapi.dynamicproxy;

import java.lang.annotation.*;

/**
 * Created by helo on 2018/12/9.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}
