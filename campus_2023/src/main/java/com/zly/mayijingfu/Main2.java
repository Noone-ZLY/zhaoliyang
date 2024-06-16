package com.zly.mayijingfu;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 输入数组的长度
        int[] nums = new int[n];  // 输入数组
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = minOperations(nums);
        System.out.println(result);
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int maxNum = -1;
        int count = 0;


        // 找到数组中的最大值
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // 计算每个数与最大值的差值的累加和
        for(int num : nums){

        }
        for (int num : nums) {
            count += maxNum - num;
        }

        return count;
    }
}
