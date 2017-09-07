package com.my.project.jse;

/**
 * @author tangfeng
 * @Description java的内部类  匿名内部类 静态内部类
 * @create 2017-07-10 11:40
 **/
public class InnerClassTest {
    /**
     * 静态内部类
     */
    static class Person {
        private String address = "swjtu,chenDu,China";
        public String mail = "josserchai@yahoo.com";//内部类公有成员

        public void display() {
            //System.out.println(id);//不能直接访问外部类的非静态成员
            System.out.println(name);//只能直接访问外部类的静态成员
            System.out.println("Inner " + address);//访问本内部类成员。
        }
    }


    private static String name = "javaJohn";
    private String id = "X001";
    public void printInfo() {
        Person person = new Person();
        person.display();
        //System.out.println(mail);//不可访问
        //System.out.println(address);//不可访问
        System.out.println(person.address);//可以访问内部类的私有成员
        System.out.println(person.address);//可以访问内部类的私有成员
        System.out.println(person.mail);//可以访问内部类的公有成员

    }


    //=============================================================================


    /**
     * 内部类
     */
    int outer_x = 100;
    class Inner {
        public int y = 10;
        private int z = 9;
        int m = 5;


        public void display() {
            System.out.println("display outer_x:" + outer_x);
        }

        private void display2() {
            System.out.println("display outer_x:" + outer_x);
        }
    }

    void test() {
        Inner inner = new Inner();
        inner.display();
        inner.display2();
        //System.out.println("Inner y:" + y);//不能访问内部内变量
        System.out.println("Inner y:" + inner.y);//可以访问
        System.out.println("Inner z:" + inner.z);//可以访问
        System.out.println("Inner m:" + inner.m);//可以访问
        InnerTwo innerTwo = new InnerTwo();
        innerTwo.show();
    }

    class InnerTwo {
        Inner innerx = new Inner();

        public void show() {
            //System.out.println(y);//不可访问Innter的y成员
            //System.out.println(Inner.y);//不可直接访问Inner的任何成员和方法
            innerx.display();//可以访问
            innerx.display2();//可以访问
            System.out.println(innerx.y);//可以访问
            System.out.println(innerx.z);//可以访问
            System.out.println(innerx.m);//可以访问
        }
    }


    public static void main(String[] args) {
        InnerClassTest staticTest = new InnerClassTest();
        staticTest.printInfo();

        staticTest.test();
    }

}


/**
 * @Description 匿名内部类
 * @author tangfeng
 * @create 2017-07-10 11:45:11
 **/

class AnonymousInnerClass{

    private String aa;

}