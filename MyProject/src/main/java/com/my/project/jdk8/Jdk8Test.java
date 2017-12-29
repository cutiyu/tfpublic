package com.my.project.jdk8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import sun.dc.pr.PRError;

import java.util.List;
import java.util.Map;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

public class Jdk8Test {

    private static List<Person> personList = Lists.newArrayList();
    private static Map<Integer,Person> pidPersonMap = Maps.newHashMap();


    static {
        personList.add(new Person(1, "xiaofeng1"));
        personList.add(new Person(2, "xiaofeng2"));
        personList.add(new Person(3, "xiaofeng3"));
    }

    static {
        pidPersonMap.put(1, new Person(1, "xiaofeng1"));
        pidPersonMap.put(2, new Person(2, "xiaofeng2"));
        pidPersonMap.put(3, new Person(3, "xiaofeng3"));
    }




    @Test
    public  void testLambdaFor(){
        //list 集合遍历
        personList.forEach(person -> System.out.println(person.getId()));
        personList.forEach(System.out::println);

        //map集合遍历
        System.out.println("===============⏫============🔽===========");
        pidPersonMap.forEach((k,v)-> System.out.println(k+v.getId()));
        pidPersonMap.forEach((k, v)-> {
            System.out.println(k);
            System.out.println(v.getName());
            if(k==2){
                System.out.println(v.toString());
            }

        });
    }


    @Test
    public void testStream(){
        //把list集合中ID=2的活着name="xiaofeng3"的集合遍历出来
        personList.stream().filter(p->p.getId().equals(2)||p.getName().equals("xiaofeng3")).forEach(System.out::println);
        //在过滤集合中再次过滤
        personList.stream().filter(p->p.getId().equals(2)||p.getName().equals("xiaofeng3")).filter(p->p.getId().equals(3)).forEach(System.out::println);


        personList.stream().filter(p->p.getId().equals(2)||p.getName().equals("xiaofeng3")).findFirst().ifPresent(p-> System.out.println(p.toString()));
    }



}
