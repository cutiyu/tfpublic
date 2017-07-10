package com.my.project.designmodel.proxy;

import jdk.nashorn.internal.scripts.JD;

/**
 * @author tangfeng
 * @Description
 * @create 2017-07-08 17:41
 **/
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        HelloInterface proxy = new JdkDynamicProxy(new HelloImpl()).getProxy();
        proxy.say("jdk dynamic proxy 晓风");
        proxy.say("jdk dynamic proxy 晓风");
    }
}
