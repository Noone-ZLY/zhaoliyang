package com.zly.yitukeji_20230921;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/21 20:01
 */
public class Main4 {
    public static void main(String[] args) {
        long mod = (long) 1e9 + 7;
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long[] dp = new long[3];
        long[] dp1 = new long[3];
        long[] dp2 = new long[3];
        dp[0] = 1;
        for(long i = 0;i < n; i++){
            dp2[1] = (dp2[1] + dp[0]) % mod;
            dp2[2] = (dp2[2] + dp[0]) % mod;

            dp1[0] = (dp1[0] + dp[1]) % mod;
            dp1[1] = (dp1[1] + dp[1]) % mod;

            dp1[0] = (dp1[0] + dp[2]) % mod;
            dp1[2] = (dp1[2] + dp[2]) % mod;

            dp = dp1;
            dp1 = dp2;
            dp2 = new long[3];
        }

        System.out.println(dp[0]);
    }
}
