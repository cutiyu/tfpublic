package com.my.project.algorithm;

/**
 * Created by tangfeng on 2017/9/8.
 *
 * 最大公约数和最小公倍数
 */
public class MaxGongyueshuAndMinGongbeishu {


    public static void main(String[] args) {
        int i = maxGongyueshu(32, 24);
        System.out.println("main 最大公约数为："+i);


        int a=23; int b=32;
        int c = minGongbeishu(32, 24);

        System.out.println("最小公倍数：" + a * b / c + "\n最大公约数：" + c);

    }


    /**
     * 最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int maxGongyueshu(int m,int n){
        if(m<0||n<0){
            System.out.println("数据错误");
            return -1;
        }

        if(n==0){
            System.out.println("最大公约数为： "+m);
            return m;
        }

        System.out.println("n=="+n+"  m%n=="+m%n);
        return maxGongyueshu(n,m%n);

    }


    public static int minGongbeishu(int m,int n){

        while (true){
            if((m=m%n)==0){
                System.out.println("1111      m=="+m%n);
                System.out.println("1111      n=="+n);
                return n;
            }

            if((n=n%m)==0){
                System.out.println("1111      n=="+n%m);
                System.out.println("1111      m=="+m);
                return m;
            }
        }
    }

}
