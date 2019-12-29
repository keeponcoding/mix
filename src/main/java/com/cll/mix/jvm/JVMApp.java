package com.cll.mix.jvm;

/**
 * @ClassName JVMApp
 * @Description TODO
 * @Author cll
 * @Date 2019-10-24 14:22
 * @Version 1.0
 **/
public class JVMApp {
    public static void main(String[] args) throws InterruptedException {

        /*
         * 一个引用 在 stack 中
         * 产生两个对象 一个在 heap 中 一个在method area/MetaSpace(1.8) 中
         */
        String s1 = new String("cll");

        /*
         * 不产生对象 因为上一步骤已经在method area中产生了 "cll"
         */
        String s2 = "cll";

        System.out.println(s1 == s2);// false 比较的是引用地址

        System.out.println(s1.equals(s2));// true 比较的是值

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ////////////////////////////////////////////////////////////////////////////////////////

        String t1 = "hello";
        String t2 = "world";
        String t3 = "hello" + "world";
        String t4 = t1 + t2; // new
        String t5 = "helloworld";
        String t6 = t4.intern();

        // == 比较的是引用地址
        System.out.println("t3 == t4 : " + (t3 == t4)); // false
        System.out.println("t3 == t5 : " + (t3 == t5)); // true
        System.out.println("t4 == t5 : " + (t4 == t5)); // false

        /*
         * It follows that for any two strings {@code s} and {@code t},
         * {@code s.intern() == t.intern()} is {@code true}
         * if and only if {@code s.equals(t)} is {@code true}.
         *
         * intern 当 equals 为true  那么 == 也为true
         */
        System.out.println("t3 == t6 : " + (t3.equals(t6))); // true
        System.out.println("t3 == t6 : " + (t3 == t6)); // true

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ////////////////////////////////////////////////////////////////////////////////////////

        Integer i1 = 50;
        Integer i2 = 50;
        System.out.println("i1 == i2 : " + (i1 == i2)); // true

        Integer i3 = 150;
        Integer i4 = 150;
        System.out.println("i3 == i4 : " + (i3 == i4)); // false  -128~127

        Integer i5 = new Integer(50);
        Integer i6 = new Integer(50);
        System.out.println("i5 == i6 : " + (i5 == i6)); // false

        Double d1 = 10.1D;
        Double d2 = 10.1D;
        System.out.println("d1 == d2 : " + (d1 == d2)); // false
    }
}
