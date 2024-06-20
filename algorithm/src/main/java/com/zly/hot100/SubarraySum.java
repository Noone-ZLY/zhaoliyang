package com.zly.hot100;

/**
 * @author : zhaoliyang
 * @description : 和为 K 的子数组
 * @createDate : 2023/10/12 12:51
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] sumPre = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sumPre[i] = sumPre[i - 1] + nums[i - 1];
        }
        for(int i = 0; i <= nums.length; i++){
            for(int j = 0; j < i; j++){
                if(sumPre[i] - sumPre[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
