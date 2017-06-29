package com.my.project.designmodel.proxy;

/**
 * @author tangfeng
 * @Description HelloInterface 的接口代理类
 * @create 2017-06-29 15:51
 **/
public class HelloStaticProxy implements HelloInterface {
    private HelloImpl helloImpl;

    public HelloStaticProxy() {
        this.helloImpl = new HelloImpl();
    }


    @Override
    public void say(String name) {
        helloImpl.say(name);
    }



}
