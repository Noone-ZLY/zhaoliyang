package com.zly.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/25 13:13
 */
public class MergeSort {
    /**
     * @param [nums]
     * @return void
     * @description 归并排序
     * @author zhaoliyang
     * @create 2023/9/25 13:43
     */
    public static void sort(int[] nums){
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
    }

    /**
     * @param [nums, left, right, temp]
     * @return void
     * @description 分治思想实现归并排序
     * @author zhaoliyang
     * @create 2023/9/25 13:43
     */
    public static void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }
    /**
     * @param [nums, left, mid, right, temp]
     * @return void
     * @description 分治中解决某个子问题
     * @author zhaoliyang
     * @create 2023/9/25 13:43
     */
    public static void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= right){
            temp[k++] = nums[j++];
        }
        k = 0;
        while(left <= right){
            nums[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[1000];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        sort(nums);
        System.out.println((Arrays.toString(nums)));
    }
}
