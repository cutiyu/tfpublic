package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description 静态代理的测试
 **/
public class HelloStaticProxyTest {
    public static void main(String[] args) {
        HelloStaticProxy staticProxy = new HelloStaticProxy();
        staticProxy.say("晓风");
    }
}
