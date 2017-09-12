package com.my.project.algorithm;

import java.util.Arrays;

/**
 * http://blog.csdn.net/xsf50717/article/details/47318123
 *
 * Created by tangfeng on 2017/9/12.
 * 冒泡排序
 *      时间复杂度：最好：O(n) ,最坏：O(n的平方)  平均：O(n的平方)
 *      空间复杂度：O(1)
 *      稳定性：稳定
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,4,1,12,16,7,21,55,48,32};
        Arrays.stream(a).forEach(x-> System.out.println(x));
        bubbleSort(a);
        Arrays.stream(a).forEach(x-> System.out.println(x));
    }

    /**
     * 第一轮遍历：正常遍历
     * 第二轮嵌套遍历：
     *       定义一个临时元素temp
     *      从第二个元素开始，
     *      比较第二个元素和第一个元素的大小，把较大值排在后面
     *      if(a[j-1]>a[j]){
     *          temp = a[j-1];
     *          a[j-1] = a[j];
     *          a[j] = temp;
     *      }
     *
     * @param a
     */
    public static void bubbleSort(int[] a){
        int temp=0;
        int len = a.length;
        for(int i=0;i<len;i++){//从数组的第一个数据开始
            for(int j=1;j<len-1;j++){//从数组的第二个数据开始
                //在第二个循环中比较当前数据和前一个数据的大小
                //若前一个数大于当前数
                if(a[j-1]>a[j]){
                    temp = a[j-1];
                    //调换两个数据的位置
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    /**
     * 优化方案
     * @param a
     */
    public static void bubbleSort1(int[] a){
        int temp = 0;
        int len = a.length;
        boolean flag = true;
        while (flag){
            flag = false;
            for(int j = 1;j<len;j++){
                if(a[j-1]>a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    flag = true;
                }

            }
        }

    }

}
