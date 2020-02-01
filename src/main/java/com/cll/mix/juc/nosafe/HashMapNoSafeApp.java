package com.cll.mix.juc.nosafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName HashMapNoSafeApp
 * @Description HashMap 线程不安全 解决方案
 *
 * 线程不安全现象
 *   java.util.ConcurrentModificationException
 *
 * 解决方案
 *
 * @Author cll
 * @Date 2020/2/1 10:54 下午
 * @Version 1.0
 **/
public class HashMapNoSafeApp {

    public static void main(String[] args) {

        // final Map<String, String> map = new HashMap<String, String>();
        // final Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
        final Map<String, String> map = new ConcurrentHashMap<String, String>();

        for (int i = 1; i <= 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,4));
                    System.out.println(map);
                }
            },String.valueOf(i)).start();
        }

    }

}
