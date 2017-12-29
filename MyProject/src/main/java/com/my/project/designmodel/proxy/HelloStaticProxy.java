package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description HelloInterface 的接口代理类
 **/
public class HelloStaticProxy implements HelloInterface {
    private HelloInterface hello;

    public HelloStaticProxy() {
        this.hello = new HelloImpl();
    }


    @Override
    public void say(String name) {
        hello.say(name);
    }



}
