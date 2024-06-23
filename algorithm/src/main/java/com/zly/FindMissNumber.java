package com.zly;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : 给定一个缺失一个数字的1~n数组，找出缺失的那个数字是什么?不缺失返回-1
 *                输入：[1, 2, 4, 5]
 *                输出：3
 * @createDate : 2023/10/15 15:04
 */
public class FindMissNumber {
    /**
     * @param [nums]
     * @return int
     * @description 数组有序，顺序查找，时间复杂度为O(n);
     * @author zhaoliyang
     * @create 2023/10/15 15:07
     */
    public static int findMissingNumber(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return -1;
    }
    /**
     * @param [nums]
     * @return int
     * @description 数组有序，二分查找，时间复杂度为O(n);
     * @author zhaoliyang
     * @create 2023/10/15 15:14
     */
    public static int findMissingNumber2(int[] nums){
        int left = 0, right = nums.length - 1;
        if(nums[nums.length - 1] == nums.length){
            return -1;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == mid + 1){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
//        System.out.println(left + " " + right + " " + nums[left] + " " + nums[right]);
        return left + 1;
    }

    /**
     * @param [nums]
     * @return int
     * @description 无序数组，利用快排
     * @author zhaoliyang
     * @create 2023/10/15 15:49
     */
    public static int findMissingNumber3(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int index = partition(nums, left, right);
            if(nums[index] == index + 1){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
        if(nums[nums.length - 1] == nums.length){
            return -1;
        }
        return left + 1;
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j){
            while (i < j && nums[j] >= pivot){
                j--;
            }
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < pivot){
                i++;
            }
            if(i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = pivot;
        return i;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(s1[i]);
        }
        System.out.println(findMissingNumber3(nums));
    }
}
