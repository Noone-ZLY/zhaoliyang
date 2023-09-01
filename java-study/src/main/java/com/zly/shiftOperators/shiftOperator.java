package com.zly.shiftOperators;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/14 17:52
 **/
public class shiftOperator {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = -1;
        // <<
        System.out.println(Integer.toBinaryString(num1 << 10) + " " + (num1 << 10));
        System.out.println(Integer.toBinaryString(num2 << 10) + " " + (num2 << 10));
        // >>
        System.out.println(Integer.toBinaryString(num1 >> 10) + " " + (num1 >> 10));
        System.out.println(Integer.toBinaryString(num2 >> 10) + " " + (num2 >> 10));
        // >>>
        System.out.println(Integer.toBinaryString(num1 >>> 10) + " " + (num1 >>> 10));
        System.out.println(Integer.toBinaryString(num2 >>> 10) + " " + (num2 >>> 10));
    }
}
