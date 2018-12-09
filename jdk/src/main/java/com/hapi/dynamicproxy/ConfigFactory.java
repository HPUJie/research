package com.hapi.dynamicproxy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

//proxy class
public final class ConfigFactory {

    private ConfigFactory() {}

    public static IConfig create(final InputStream is) throws IOException {

        final Properties properties = new Properties();
        properties.load(is);

        return (IConfig) Proxy.newProxyInstance(IConfig.class.getClassLoader(),
                new Class[] { IConfig.class }, new PropertyMapper(properties));

    }

    public static final class PropertyMapper implements InvocationHandler {

        private final Properties properties;

        public PropertyMapper(Properties properties) {
            this.properties = properties;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            final Value value = method.getAnnotation(Value.class);

            if (value == null) return null;

            String property = properties.getProperty(value.value());
            if (property == null) return (null);

            final Class<?> returns = method.getReturnType();
            if (returns.isPrimitive())
            {
                if (returns.equals(int.class)) return (Integer.valueOf(property));
                else if (returns.equals(long.class)) return (Long.valueOf(property));
                else if (returns.equals(double.class)) return (Double.valueOf(property));
                else if (returns.equals(float.class)) return (Float.valueOf(property));
                else if (returns.equals(boolean.class)) return (Boolean.valueOf(property));
            }

            return property;
        }

    }
}