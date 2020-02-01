package com.cll.mix.juc.nosafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName HashSetNoSafeApp
 * @Description HashSet 线程不安全 案例
 *
 * 线程不安全现象
 *   java.util.ConcurrentModificationException
 *
 * 解决方案
 *
 * @Author cll
 * @Date 2018/2/1 10:44 下午
 * @Version 1.0
 **/
public class HashSetNoSafeApp {

    public static void main(String[] args) {

        // final HashSet<String> set = new HashSet<String>();
        // final Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        final Set<String> set = new CopyOnWriteArraySet<String>();

        for (int i = 1; i <= 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    set.add(UUID.randomUUID().toString().substring(0,4));
                    System.out.println(set);
                }
            },String.valueOf(i)).start();
        }
    }

}
