package com.my.project.jse.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangfeng
 * @Description
 * @create 2017-09-07 18:50
 **/
public class VolatileTest {

    public static volatile AtomicInteger a = new AtomicInteger(10);

    public static void main(String[] args) {

        while (a.intValue()>0){

           Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    cutNo();
                }
            });
           if(a.intValue()==0){
               Thread.currentThread().interrupt();
           }else{
               Thread.currentThread().interrupt();
           }
        }
        System.out.println("执行结束==a=="+a);
    }


    public   synchronized   static AtomicInteger cutNo(){
        a=new AtomicInteger(a.intValue()-1);
        System.out.println("a=========="+a);
        return a;
    }
}
