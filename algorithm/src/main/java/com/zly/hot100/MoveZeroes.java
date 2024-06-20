package com.zly.hot100;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/6 15:42
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                int temp = nums[j];
                if(nums[i] == 0){
                    nums[j] = 0;
                }
                nums[i++] = temp;
            }
            j++;
        }
    }
}
