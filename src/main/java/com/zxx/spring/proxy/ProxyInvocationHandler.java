package com.zxx.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zxx
 * @date 2020/11/13 10:26
 * @description 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;








    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
