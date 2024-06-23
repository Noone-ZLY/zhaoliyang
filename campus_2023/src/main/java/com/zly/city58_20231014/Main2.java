package com.zly.city58_20231014;

import java.util.Arrays;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/14 19:42
 */
public class Main2 {
    public int minTolls (int[] toll) {
        // write code here
        int n = toll.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = toll[0];
        dp[1] = toll[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + toll[i];
        }
        dp[n] = Math.min(dp[n-1], dp[n-2]);
        return dp[n];
    }
}
