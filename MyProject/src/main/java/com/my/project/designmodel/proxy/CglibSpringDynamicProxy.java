package com.my.project.designmodel.proxy;



import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;


/**
 * @author tangfeng
 * @Description Cglib 实现动态代理
 * @create 2017-07-10 10:40
 **/
public class CglibSpringDynamicProxy implements MethodInterceptor {

    private static CglibSpringDynamicProxy cglibProxyInstance = new CglibSpringDynamicProxy();
    public CglibSpringDynamicProxy() {
    }

    public static CglibSpringDynamicProxy getInstance(){
        return cglibProxyInstance;
    }

    public <T> T getProxy(Class<T> clazz){
        return (T)org.springframework.cglib.proxy.Enhancer.create(clazz,this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, org.springframework.cglib.proxy.MethodProxy methodProxy) throws Throwable {

        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();

        return result;
    }




    private void before(){
        System.out.println("=========== before==========");
    }
    private void after(){
        System.out.println("=========== after==========");
    }









    /**
     * @Description Spring cglib 动态代理
     * @author tangfeng
     * @create 2017-07-10 11:11:24
     **/
    static  class SpringCglibProxy implements org.springframework.cglib.proxy.MethodInterceptor{

        private static SpringCglibProxy springCglibProxy = new SpringCglibProxy();

        public SpringCglibProxy() {
        }

        public static SpringCglibProxy getInstance(){
            return springCglibProxy;
        }

        public <T> T getProxy(Class<T> clazz){
            return (T)org.springframework.cglib.proxy.Enhancer.create(clazz,this);
        }
        @Override
        public Object intercept(Object o, Method method, Object[] objects, org.springframework.cglib.proxy.MethodProxy methodProxy) throws Throwable {

            CglibSpringDynamicProxy.getInstance().before();
            Object result = methodProxy.invokeSuper(o, objects);
            CglibSpringDynamicProxy.getInstance().after();

            return result;
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


