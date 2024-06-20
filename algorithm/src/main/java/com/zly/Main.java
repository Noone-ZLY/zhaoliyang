package com.zly;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.awt.dnd.DropTarget;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] taskTime = new int[M];
        int[][] depends = new int[M][M];
        int[][] dp = new int[M][N];
        for(int i = 0; i < M; i++){
            taskTime[i] = scanner.nextInt();
        }
        for(int i = 0; i < M; i++){
            int key = scanner.nextInt();
            if(key != 0){
                depends[i][key-1] = 1;
            }
        }
        solve(M, N, taskTime, depends, dp);
        System.out.println(dp[M-1][N-1]);

    }
    public static void solve(int M, int N, int[] taskTime, int[][] depends, int[][] dp){
        List<Integer> res = topoSort(M, N, depends);
        int[] taskP = new int[M];
        for(int i = 0; i < M; i++){
            taskP[i] = res.get(i);
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(i == 0){
                    dp[taskP[i]][j] = taskTime[taskP[i]];
                }else{
                    dp[taskP[i]][j] = Math.min(dp[taskP[i-1]][j], dp[taskP[i-1]][j-1] + taskTime[taskP[i]]);
                }
            }
        }
    }
    public static List<Integer> topoSort(int M, int N, int[][] depends){
        List<Integer> res = new ArrayList<>();
        int[] in = new int[M];
        for(int[] depend : depends){
            for(int i : depend){
                in[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < M; i++){
            if(in[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int task = queue.poll();
            res.add(task);
            for(int i : depends[task]){
                in[i]--;
                if(in[i] == 0){
                    queue.offer(i);
                }
            }
        }
        if(res.size() == M){
            throw new IllegalArgumentException();
        }
        return res;
    }
}