package com.zly.Sort;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/17 14:58
 **/
public class Sort {
    public static void mergeSort(int left, int right, int[] nums, int[] temp){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, nums, temp);
        mergeSort(mid+1, right, nums, temp);
        merge(left, right, nums, temp);
    }

    public static void merge(int left, int right, int[] nums, int[] temp){
        int i = left, j = right;

    }

    public static void main(String[] args) {
    }
}
