package com.zly.hot100;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : 最大子数组和
 * @createDate : 2023/10/12 13:47
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            temp = Math.max(temp + nums[i], nums[i]);
            res = Math.max(temp, res);
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxSubArray(nums));
    }
}
