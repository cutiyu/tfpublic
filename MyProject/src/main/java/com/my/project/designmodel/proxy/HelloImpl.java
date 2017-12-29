package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description  被代理的接口实现
 **/
public class HelloImpl implements HelloInterface {
    @Override
    public void say(String name) {
        System.out.println("helloImpl say : hello,"+name);
    }
}
