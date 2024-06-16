package com.zly.zijie_20230917;
import java.util.*;

public class Main2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 读取数组长度
            int n = scanner.nextInt();

            // 读取数组a
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // 读取数组b
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            // 计算最多有多少个0
            int maxZeroCount = computeMaxZeroCount(n, a, b);

            // 输出结果
            System.out.println(maxZeroCount);
        }

        private static int computeMaxZeroCount(int n, int[] a, int[] b) {
            int maxZeroCount = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 0 && b[i] == 0) {
                    maxZeroCount++;
                } else if (a[i] != 0) {
                    double mul = (double) (b[i] - 0) / a[i];
                    if (mul == (int) mul && mul <= 0) {
                        maxZeroCount++;
                    }
                }
            }

            return maxZeroCount;
        }
}
