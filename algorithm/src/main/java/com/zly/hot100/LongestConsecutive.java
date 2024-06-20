package com.zly.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhaoliyang
 * @description : 最长连续子数组
 * @createDate : 2023/10/6 15:06
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int curNum = num;
                int res = 1;
                while(set.contains(curNum + 1)){
                    curNum = curNum + 1;
                    res++;
                }
                ans = Math.max(res, ans);
            }
        }
        return ans;
    }
}
