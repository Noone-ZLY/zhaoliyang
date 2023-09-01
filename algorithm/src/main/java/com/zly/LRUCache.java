package com.zly;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/30 17:34
 **/
class Node{
    Map<Integer, Integer> val;
    Node pre = null;
    Node next = null;
}
public class LRUCache {
    private Node cache;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if(this.size > 0){

        }
        return -1;
    }

    public void put(int key, int value) {

    }
}
