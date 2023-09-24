package com.zly;

import java.util.Scanner;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 18:24
 * @description :
 */
public class Gcd {
    public static int gcd(int num1, int num2){
        return num1 % num2 == 0 ? num2 : gcd(num2, num1 % num2);
    }
    public static int lcm(int num1, int num2){
        return (num1 * num2) / gcd(num1, num2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}
