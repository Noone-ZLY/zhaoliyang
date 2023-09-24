package com.zly.tencent_20230910;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        int left = 0, right = n;
        long ans = 0;
        while(left < right && a[left] < right){
            ans += a[right] - a[left];
            left++;
            right--;
        }
        System.out.println(ans);
    }
}