package com.my.project.designmodel.proxy;

import jdk.nashorn.internal.scripts.JD;

/**
 * @author tangfeng
 * @Description
 **/
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        HelloInterface hello  = new HelloImpl();
        HelloInterface proxy = new JdkDynamicProxy(new HelloImpl()).getProxy();
        proxy.say("jdk dynamic proxy 晓风");
    }
}
