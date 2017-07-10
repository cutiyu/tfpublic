package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description
 * @create 2017-07-10 13:59
 **/
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        HelloInterface hello = CglibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("cglib dynamic proxy 晓风");

        /*CglibDynamicProxy.SpringCglibProxy springCglibProxy = CglibDynamicProxy.SpringCglibProxy.getInstance();
        HelloInterface proxy = springCglibProxy.getProxy(HelloImpl.class);
        proxy.say("spring cglib dynamic proxy 晓风");*/

        CglibSpringDynamicProxy springCglibProxy = CglibSpringDynamicProxy.getInstance();
        HelloInterface proxy = springCglibProxy.getProxy(HelloImpl.class);
        proxy.say("spring cglib dynamic proxy 晓风");
    }
}
