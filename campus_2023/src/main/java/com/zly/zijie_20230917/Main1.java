package com.zly.zijie_20230917;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取字符串长度和询问次数
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        // 读取字符串
        String str = scanner.nextLine();

        // 构建KMP算法所需的next数组
        int[] next = getNextArray(str);

        // 处理每次查询
        for (int i = 0; i < q; i++) {
            // 读取查询字符串
            String query = scanner.nextLine();

            // 使用KMP算法计算查询字符串在给定字符串中出现的次数
            int count = kmpCount(str, query, next);

            // 输出结果
            System.out.println(count);
        }
    }

    // KMP算法计算子串在字符串中出现的次数
    private static int kmpCount(String str, String subStr, int[] next) {
        int count = 0;
        int i = 0, j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == subStr.charAt(j)) {
                i++;
                j++;
                if (j == subStr.length()) {
                    count++;
                    j = next[j];
                }
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return count;
    }

    // 构建KMP算法所需的next数组
    private static int[] getNextArray(String subStr) {
        int[] next = new int[subStr.length() + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < subStr.length()) {
            if (j == -1 || subStr.charAt(i) == subStr.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}