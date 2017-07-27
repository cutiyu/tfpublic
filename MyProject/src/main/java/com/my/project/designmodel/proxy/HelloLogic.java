package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description  被代理的接口实现
 * @create 2017-06-29 15:49
 **/
public class HelloLogic  {

    public void say(String name) {
        System.out.println("helloImpl say : hello,"+name);
    }
}
