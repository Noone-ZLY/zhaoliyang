package com.zly.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhaoliyang
 * @description : 三数之和
 * @createDate : 2023/10/6 15:50
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){left++;}
                    while(left < right && nums[right] == nums[right-1]){right--;}
                }else if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
