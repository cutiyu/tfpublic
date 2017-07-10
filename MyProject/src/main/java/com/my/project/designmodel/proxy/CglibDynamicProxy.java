package com.my.project.designmodel.proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tangfeng
 * @Description Cglib 实现动态代理
 * @create 2017-07-10 10:40
 **/
public class CglibDynamicProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, net.sf.cglib.proxy.MethodProxy methodProxy) throws Throwable {
        return null;
    }


















    /**
     * @Description Spring cglib 动态代理
     * @author tangfeng
     * @create 2017-07-10 11:11:24
     **/
    static  class SpringCglibProxy implements org.springframework.cglib.proxy.MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            return null;
        }
    }


    /**
     * @Description spring 的拦截器
     * @author tangfeng
     * @create 2017-07-10 10:54:50
     **/
    static class DefinitionInterceptor implements org.aopalliance.intercept.MethodInterceptor{

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            return null;
        }
    }


}


