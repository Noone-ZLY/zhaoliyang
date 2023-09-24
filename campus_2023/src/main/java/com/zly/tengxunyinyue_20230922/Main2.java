package com.zly.tengxunyinyue_20230922;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/22 19:07
 */
public class Main2 {
    public static int cntOfMethod (String t) {
        // write code here
        int n = t.length();
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1];
            if(i > 2){
                dp[i] = (dp[i] + dp[i-2]) % mod;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(cntOfMethod(str));
    }
}
