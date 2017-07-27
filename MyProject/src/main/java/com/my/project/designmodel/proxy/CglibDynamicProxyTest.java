package com.my.project.designmodel.proxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author tangfeng
 * @Description
 * @create 2017-07-10 13:59
 **/
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        HelloInterface proxy1 = CglibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        proxy1.say("cglib dynamic proxy 晓风");



        HelloLogic proxy = CglibSpringDynamicProxy.getInstance().getProxy(HelloLogic.class);
        proxy.say("spring cglib dynamic proxy class 晓风");

        /*spring cglib 不能代理实现接口的类？ 如下执行会报错*/
        /*HelloImpl proxy2 = CglibSpringDynamicProxy.getInstance().getProxy(HelloImpl.class);
        proxy2.say("spring cglib dynamic proxy class impl interface 晓风");*/

    }
}
