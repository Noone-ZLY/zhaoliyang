package com.zly.shengqu_2023_09_10;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int R = scanner.nextInt();
        int[] targets = new int[R];
        for (int i = 0; i < R; i++) {
            targets[i] = scanner.nextInt();
        }
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            graph[u][v] = c;
            graph[v][u] = c;
        }
        int[][] dp = new int[1 << R][R];
        for (int mask = 1; mask < (1 << R); mask++) {
            Arrays.fill(dp[mask], Integer.MAX_VALUE);
        }
        for (int mask = 1; mask < (1 << R); mask++) {
            for (int i = 0; i < R; i++) {
                if ((mask & (1 << i)) != 0) {
                    int prevMask = mask ^ (1 << i);
                    for (int j = 0; j < R; j++) {
                        if ((prevMask & (1 << j)) != 0) {
                            dp[mask][i] = Math.min(dp[mask][i], dp[prevMask][j] + graph[targets[j]][targets[i]]);
                        }
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            minCost = Math.min(minCost, dp[(1 << R) - 1][i]);
        }
        System.out.println(minCost);
    }
}