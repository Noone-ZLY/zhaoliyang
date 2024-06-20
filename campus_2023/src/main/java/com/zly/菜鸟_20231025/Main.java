package com.zly.菜鸟_20231025;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/25 19:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int distinctValues = countDistinctValues(nums);
        System.out.println(distinctValues);
    }

    private static int countDistinctValues(int[] a) {
        int n = a.length;
        int maxBit = getMaxBit(a); // 获取最高位的位置
//        System.out.println(maxBit);
        int distinctValues = 0;
        for (int bit = maxBit; bit >= 0; bit--) {
            int count = 0;
            for (int num : a) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            System.out.println(count);
            if (count >= 1) {
                distinctValues |= (1 << bit);
            }
        }

        return distinctValues;
    }

    private static int getMaxBit(int[] a) {
        int maxNum = 0;
        for (int num : a) {
            maxNum = Math.max(maxNum, num);
        }
        int maxBit = 0;
        while (maxNum > 0) {
            maxNum >>= 1;
            maxBit++;
        }
        return maxBit - 1;
    }
}
