package com.my.project.jse.queueAndstack;

import java.util.Stack;

/**
 * Created by tangfeng on 2017/9/12.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack  stack  = new Stack();

        stack.add("111");
        stack.add("222");
        stack.add("333");
        stack.add("555");
        System.out.println(stack.toString()); //[111, 222, 333, 555]

        //stack.forEach(a-> System.out.println("遍历元素  "+a));

        System.out.println("第一个元素 "+stack.firstElement());

        System.out.println("是否为空 "+stack.empty());//是否为空
        System.out.println("查看栈顶对象 "+stack.peek());//查看栈顶对象
        System.out.println("添加元素到栈顶 "+stack.push("444"));//添加元素到栈顶
        //System.out.println("移除栈顶对象，并作为函数的值 返回该对象 "+stack.pop());//移除栈顶对象，并作为函数的值 返回该对象
        System.out.println("搜索元素 "+stack.search("5555")); //搜索元素
        System.out.println("搜索元素 "+stack.search("222"));

        //stack.forEach(a-> System.out.println("遍历元素  "+a));



    }
}
