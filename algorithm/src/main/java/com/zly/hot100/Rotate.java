package com.zly.hot100;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/12 20:04
 */
public class Rotate {
    public int[] rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        int j = 0;
        for(int i = nums.length - k; i < nums.length; j++){
            res[j++] = nums[i];
        }
        for(int i = 0; i < nums.length - k; i++){
            res[j++] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
