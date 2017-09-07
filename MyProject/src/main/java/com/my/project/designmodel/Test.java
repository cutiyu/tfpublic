package com.my.project.designmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangfeng
 * @Description
 * @create 2017-06-29 15:45
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(1L<<65L);

        Map map  = new HashMap();
        map.put("key","value" );
       // map.putAll(null);
        String key1 = (String) map.get("key");

        boolean key = map.containsKey("key");
        boolean value = map.containsValue("value");

        map.size();
        map.clear();
        map.hashCode();

        map.entrySet();
        map.keySet();
        map.values();

        map.equals("");
        map.isEmpty();















        int a = 2;
        System.out.println("说明：int 类型32位 以下省略号连接的前后，总位数为32位， 正数：省略号用0填充，负数省略号用1填充");
        System.out.println("8   0000...1000 -->右移2位-->0000...0010 --->2");
        System.out.println("正数右移高位补0                  8>>2 = "+(8>>2));
        System.out.println("负数在正数的基础上右移高位置为1   -8>>2 = "+(-8>>2));
        System.out.println("\n");
        System.out.println("8   0000...1000 -->无符号右移2位-->0000...0010 --->2");
        System.out.println("无符号右移，正数高位补0       8>>>2 = "+(8>>>2));

        System.out.println("无符号右移，负数高位补0       -8>>>2 = "+(-8>>>2));
        System.out.println("8二进制          0000...1000");
        System.out.println("-8: 8取反        1111...0111");
        System.out.println("-8: 8取反后加1   1111...1000 ");
        System.out.println("-8: 右移两位，高位补0：  001111...10     00(这后两个1剔除) ");

        System.out.println("\n8的二进制   "+Integer.toBinaryString(8));
        System.out.println("-8的二进制  "+Integer.toBinaryString(-8));

        System.out.println("\n");
        System.out.println("左移低位补0                   8<<2 = "+(8<<2));
        System.out.println("左移低位补0，带符号           -8<<2 = "+(-8<<2));

        System.out.println("==========================");
        System.out.println("2<<29 = "+(2<<29));

        System.out.println("2的二进制                0000 0000 0000 0000 0000 0000 0000 0010");
        System.out.println("2的二进制反码            1111 1111 1111 1111 1111 1111 1111 1101");
        System.out.println("2的二进制反码后补码+1    1111 1111 1111 1111 1111 1111 1111 1101  +1");
        System.out.println("得到-2的二进制           1111 1111 1111 1111 1111 1111 1111 1110");
                /*1000 0000 0000 0000 0000 0000 0000 0010   0
                  001000 0000 0000 0000 0000 0000 0000 00
                  01000 0000 0000 0000 0000 0000 0000 000   1
                  1111 1111 1111 1111 1111 1111 1111 1110*/
        System.out.println("-2>>>2 = "+(-2>>>2));
        System.out.println("==========================");


        System.out.println(a^(12>>>2));

        System.out.println(8^3);
        Integer b = 1;
        char aa = 'a';
        System.out.println(b.byteValue());
        System.out.println(aa);
        Integer ab = -8;
        Integer abc = 8;

    }
}
