package com.my.project.jse.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xianghan on 2017/9/7.
 */
public class SpikeConstant {
    private static  SpikeConstant spikeConstant;
    public static synchronized SpikeConstant getInstance(){
        if (spikeConstant==null) {
            spikeConstant=new SpikeConstant();
        }
        return spikeConstant;
    }

    public static AtomicInteger SpikeTotle=new AtomicInteger(100);
    private static Set userList = Collections.synchronizedSet(new HashSet());
    private final Object lockObj = new Object();

//    public int getSpikeTotle() {
//        System.out.println(SpikeTotle);
//        return SpikeTotle;
//    }

    public synchronized String  subCount(String userId, Integer count){
        {
            if(userList.contains(userId)){
                return userId+":已在队列中";
            }
            if(SpikeTotle.get()>0){
                if(SpikeTotle.get()>=count){
                    userList.add(userId);
                    SpikeTotle.addAndGet(-count);
//                    //唤醒所有在lockObj对象上等待的线程
//                    lockObj.notifyAll();
                    return userId+":成功购买"+count+"个";
                }else{
                    return userId+":购买数量大于活动数量";
                }
            }else {
                return userId+":活动已售罄";
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        while (SpikeConstant.SpikeTotle.get()>0){
            System.out.println("while:>>>>>>>>>>>>>"+SpikeConstant.SpikeTotle);
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("活动剩余量："+SpikeConstant.SpikeTotle);
                    String userId=Thread.currentThread().getId()+String.valueOf(System.currentTimeMillis());
                    System.out.println(SpikeConstant.getInstance().subCount(userId, 1+Integer.valueOf(userId.substring(userId.length()-1))));
                    if(SpikeConstant.SpikeTotle.get()==0){
                        //service.isShutdown();
                    }
                }
            });
            if(service.isShutdown()){
                System.out.println("活动已结束！");
                break;
            }
        }
    }

}
