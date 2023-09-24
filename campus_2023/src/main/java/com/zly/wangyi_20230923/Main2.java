package com.zly.wangyi_20230923;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 14:57
 */
public class Main2 {
    private static final int mod = (int)(1e9 + 7);
    public static double x(int[] nums){
        int n = nums.length;
        double avgSum = 0;
        for(int i = 1; i <= n; i++){
            avgSum += b(nums, i, 0, 0) % mod;
        }
        return avgSum;
    }
    public static double b(int[] nums, int k, int start, int sum){
        if(k == 0){
            return sum;
        }
        double avg = 0;
        for(int i = start; i < nums.length - k; i++){
            avg += b(nums, k-1, i+1, sum + nums[i]) % mod;
        }
        return avg;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        double avgSum = x(nums);
        System.out.println(avgSum);
    }
}
