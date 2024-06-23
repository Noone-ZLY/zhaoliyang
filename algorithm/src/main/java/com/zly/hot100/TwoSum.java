package com.zly.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : 两数之和
 * @createDate : 2023/10/6 14:39
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoSum1(int[] nums, int target){
        int[][] array = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            array[i][0] = nums[i];
            array[i][1] = i;
        }
        Arrays.sort(array, (int[] a, int[] b) -> (a[0] - b[0]));
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(array[left][0] + array[right][0] == target){
                return new int[]{array[left][1], array[right][1]};
            }
            if(array[left][0] + array[right][0] < target){
                left++;
            }else if(array[left][0] + array[right][0] > target){
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }
}
