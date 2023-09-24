package com.zly.kedaxunfei;

import java.util.Map;
import java.util.Scanner;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/9 14:56
 * @description :
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        int maxLength = fun(nums, m);
        System.out.println(maxLength);
    }

    public static int fun(int[] nums, int m){
        int n = nums.length;
        int left = 0, right = 1;
        long sum = nums[0];
        int count = 1;
        int maxLength = 1;

        while(right < n){
            if((sum / count) >= m){
                maxLength = Math.max(maxLength, right - left + 1);
                sum += nums[right];
                count++;
                right++;
            }else {
                sum -= nums[left];
                count--;
                left++;
            }
        }
        return maxLength;
    }
}
