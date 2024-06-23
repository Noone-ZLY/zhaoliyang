package com.zly.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/17 14:58
 **/
public class Sort {
    public static void sort(int[] nums){
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
    }
    public static void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right){
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
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


    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public static int partition(int[] nums, int left, int right){
        int i = left, j = right;
        int pivot = nums[left];
        while (i < j){
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
        int[] nums = new int[100];
        int[] mergeSortNums = new int[100];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
            mergeSortNums[i] = random.nextInt(10);
        }
        quickSort(nums, 0, nums.length - 1);
        sort(mergeSortNums);
        System.out.println((Arrays.toString(nums)));
        System.out.println((Arrays.toString(mergeSortNums)));
    }
}
