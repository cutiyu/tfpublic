package com.my.project.designmodel.proxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * @author tangfeng
 * @Description Cglib 实现动态代理
 **/
public class CglibDynamicProxy implements MethodInterceptor {

    private static CglibDynamicProxy cglibProxyInstance = new CglibDynamicProxy();


    public static CglibDynamicProxy getInstance(){
        return cglibProxyInstance;
    }
    public <T> T getProxy(Class<T> clazz){
        return (T) Enhancer.create(clazz,this);
    }
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        before();
        Object result = methodProxy.invokeSuper(target, args);
        after();

        return result;
    }


    private void before(){
        System.out.println("=========== before==========");
    }
    private void after(){
        System.out.println("=========== after==========");
    }



}


