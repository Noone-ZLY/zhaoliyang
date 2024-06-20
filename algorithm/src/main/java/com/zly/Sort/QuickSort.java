package com.zly.Sort;

import java.util.Arrays;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/25 13:13
 */
public class QuickSort {
    public static void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * @param [nums, left, right]
     * @return void
     * @description 根据确定基准元素位置后进一步的划分
     * @author zhaoliyang
     * @create 2023/9/25 14:14
     */
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }
    /**
     * @param [nums, left, right]
     * @return int
     * @description partition操作确定基准元素的位置
     * @author zhaoliyang
     * @create 2023/9/25 14:13
     */
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left, j = right;
        while(i < j){
            while (i < j && nums[j] >= pivot){
                j--;
            }
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] < pivot){
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
        int nums[] = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7, 9, 2,2};
//        sort(nums);
        System.out.println(partition(nums, 0, nums.length - 1));
    }
}
