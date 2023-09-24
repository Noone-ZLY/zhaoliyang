package com.zly.yongyou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/18 19:38
 */
public class Main2 {
    public static long minOperations (int[] nums1, int[] nums2, int k) {
        // write code here
        int sum = Arrays.stream(nums1).sum();
        int sum1 = Arrays.stream(nums2).sum();
        if(sum != sum1){
            return -1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> integerSet = new HashSet<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        integerSet.retainAll(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        int ans = 0;
        for(int num : integerSet){
            ans += num;
        }
        return (int)((sum-ans) / k);
    }
    public static void main(String[] args) {

    }
}
