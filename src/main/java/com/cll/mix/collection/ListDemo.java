package com.cll.mix.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ListDemo
 * @Description list相关
 * @Author cll
 * @Date 2019-06-12 22:32
 * @Version 1.0
 **/
public class ListDemo {

    public static void main(String[] args) {
        List list = new LinkedList();
        //System.out.println(16 >> 1);
    }

    // list默认初始化容量 private static final int DEFAULT_CAPACITY = 10;
    // list集合最大容量  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;   -- 2147483627 - 8
    // 扩容机制 原容量 + (原容量 >> 1)  也就是 原容量+原容量/2

}
