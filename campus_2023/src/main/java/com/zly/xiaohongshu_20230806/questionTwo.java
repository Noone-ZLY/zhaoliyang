package com.zly.xiaohongshu_20230806;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/6 13:39
 **/
public class questionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        int H = scanner.nextInt();
        long[][] arr = new long[n][3];
        long[][][] dp = new long[n + 1][T + 1][H + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextLong();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= T; j++) {
                for (int k = 1; k <= H; k++) {
                    if (j < arr[i - 1][0] || k < arr[i - 1][1]) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][(int) (j - arr[i-1][0])][(int) (k - arr[i - 1][1])] + arr[i - 1][2]);
                    }
                }
            }
        }
        System.out.println(dp[n][T][H]);


    }
}
