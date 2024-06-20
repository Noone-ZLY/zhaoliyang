package com.zly;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/15 18:43
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        Random random = new Random();
        for(int i =0; i < 1000; i++) {
            int key = random.nextInt(100);
            treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
            String a;
            a.c
        }
    }
}
