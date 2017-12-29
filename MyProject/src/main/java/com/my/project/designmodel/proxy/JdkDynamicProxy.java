package com.my.project.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tangfeng
 * @Description
 **/
public class JdkDynamicProxy implements InvocationHandler{

    private Object target;

    public JdkDynamicProxy() {
        super();
    }
    public  JdkDynamicProxy(Object target){
        this.target = target;
    }

    public <T> T getProxy(){
       T t =  (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //Object invoke = method.invoke(proxy, args);
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }


    private void before(){
        System.out.println("=========== before==========");
    }
    private void after(){
        System.out.println("=========== after==========");
    }



}
