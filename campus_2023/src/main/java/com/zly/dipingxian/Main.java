package com.zly.dipingxian;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 19:10
 */
public class Main {
    public static int maxArea (int[] height) {
        // write code here
        int i = 0, j = height.length - 1;
        int res = 0;
        while(i < j){
            int temp = Math.min(height[i], height[j]);
            res = Math.max(res, (j - i) * temp);
            if(height[i] < height[j]){
                ++i;
            }else {
                j--;
            }
        }
        return res;
    }
}
