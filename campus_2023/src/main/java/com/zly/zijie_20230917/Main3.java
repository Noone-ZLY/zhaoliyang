package com.zly.zijie_20230917;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度 n
        int n = scanner.nextInt();

        // 读取数组 a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 读取数组 b
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 初始化最大 0 的数量为 0
        int maxZeros = 0;

        // 遍历每个可能的 mul 值
        for (double mul = -1.0; mul <= 1.0; mul += 0.0001) {
            // 统计数组 c 中 0 的数量
            int zeros = 0;
            for (int i = 0; i < n; i++) {
                double c = mul * a[i] + b[i];
                if (Math.abs(c) < 1e-9) { // 设置一个误差范围
                    zeros++;
                }
            }

            // 更新最大 0 的数量
            maxZeros = Math.max(maxZeros, zeros);
        }

        // 输出最大 0 的数量
        System.out.println(maxZeros);
    }

}
