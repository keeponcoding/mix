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

    }
}
