package com.zly.hot100;

import java.util.Arrays;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/17 13:21
 */
public class ProductExceptSelf {
    /**
     * @param [nums]
     * @return int[]
     * @description 238. 除自身以外数组的乘积
     * @author zhaoliyang
     * @create 2023/10/17 13:21
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] mul = new int[nums.length];
        int[] mulReverse = new int[nums.length];
        mul[0] = nums[0];
        mulReverse[0] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            mul[i] = nums[i] * mul[i-1];
            mulReverse[i] = nums[nums.length - i - 1] * mulReverse[i-1];
        }
        System.out.println(Arrays.toString(mul));
        System.out.println(Arrays.toString(mulReverse));
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[i] = mulReverse[nums.length - 2];
            } else if (i == nums.length - 1) {
                res[i] = mul[nums.length - 2];
            }else {
                res[i] = mul[i-1] * mulReverse[nums.length - i - 2];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
