package com.cll.mix.juc.nosafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName ArrayListNoSafeApp
 * @Description ArrayList 线程不安全 案例
 *
 * 1.线程不安全现象
 *   java.util.ConcurrentModificationException
 *
 * 2.解决方案
 *   ① new Vector<String>();
 *       @since JDK1.0
 *       效率低  不建议使用  方法添加 synchronized 实现线程安全
 *   ② Collections.synchronizedList(new ArrayList<String>());
 *       @since 1.2
 *       通过 synchronized() {}  synchronized代码块实现线程安全
 *       注意 Collection、Collections 区别
 *   ③ new CopyOnWriteArrayList<String>();
 *       @since 1.5
 *       使用 ReentrantLock 加锁实现的线程安全 读写分离的思想
 *
 * @Author cll
 * @Date 2020/2/1 9:30 下午
 * @Version 1.0
 **/
public class ArrayListNoSafeApp {

    public static void main(String[] args) {
        /*
         * 线程不安全
         * 会出现 java.util.ConcurrentModificationException 异常
         */
        // final List<String> list = new ArrayList<String>();

        // final List<String> list = new Vector<String>();

        // final List<String> list = Collections.synchronizedList(new ArrayList<String>());

        final List<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,4));
                    System.out.println(list);
                }
            },String.valueOf(i)).start();
        }
    }

}
