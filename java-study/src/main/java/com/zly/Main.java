package com.zly;

public class Main {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(a);
        System.out.println(getType(a));
    }
    public static String getType(Object o){
        return o.getClass().toString();
    }
}