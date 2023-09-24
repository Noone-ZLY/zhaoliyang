package com.zly.tencent_20230910;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(getMinSum(nums, k));
    }

    public static int getMinSum(int[] nums, int k) {
        Arrays.sort(nums);
        int bit = 0;
        while ((1 << bit) <= nums[nums.length - 1]) {
            bit++;
        }
        bit--;
        int count = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if ((num & (1 << bit)) != 0) {
                count++;
            }
        }
        while (k > 0 && bit >= 0 && count > 0) {
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    nums[i] -= (1 << bit);
                    sum -= (1 << bit);
                    count--;
                    break;
                }
            }
            bit--;
            k--;
        }
        return (int) sum;
    }
}