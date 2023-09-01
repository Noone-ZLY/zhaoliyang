package com.zly.GenericsTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/28 18:42
 **/
public class addOverloadTest {
    public static void main(String[] args) {
        int intA = 1, intB = 2;
        float floatA = 1.0F, floatB = 2.0F;
        double doubleA = 1.0D, doubleB = 2.0D;
        System.out.println(add(intA, intB));
        System.out.println(add(floatA, floatB));
        System.out.println(add(doubleA, doubleB));
    }
    private static int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }
}
