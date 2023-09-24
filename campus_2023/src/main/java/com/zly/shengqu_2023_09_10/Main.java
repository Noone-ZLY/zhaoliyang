package com.zly.shengqu_2023_09_10;

import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static TreeSet<Integer>[] adj;
    static int[] maxTime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        adj = new TreeSet[n];
        maxTime = new int[n];

        for (int i = 1; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            adj[i] = new TreeSet<>();
        }

        for (int i = 1; i < n; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int k = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
            maxTime[x] = Math.max(maxTime[x], k + a[y]);
            maxTime[y] = Math.max(maxTime[y], k + a[x]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxTime[i]);
        }

        System.out.println(ans);
    }
}