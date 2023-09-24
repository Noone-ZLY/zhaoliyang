package com.zly.Sort;

import java.util.Arrays;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/17 14:58
 **/
public class Sort {
    public static int[] sort(int[] nums){
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length, temp);
        System.out.println(Arrays.toString(temp));
        return temp;
    }
    public static void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, k = 0;
        while(i < mid + 1 && j < right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i < mid){
            temp[k++] = nums[i++];
        }
        while(j < right){
            temp[k++] = nums[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 8, 4, 7, 2, 6};
        nums = sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
