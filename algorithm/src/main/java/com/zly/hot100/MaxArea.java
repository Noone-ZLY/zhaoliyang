package com.zly.hot100;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/6 15:18
 */
public class MaxArea {
    public static int maxArea(int[] nums){
        int i = 0, j = nums.length - 1;
        int res = (j - i) * Math.min(nums[i], nums[j]);
        while(i < j){
            int temp = nums[i] < nums[j] ? (j - i) * nums[i++] : (j - i)*nums[j--];
            res = Math.max(temp, res);
        }
        return res;
    }
}
