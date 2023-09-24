package com.zly.compus_360;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 17:49
 */
public class Main {
    public static int res;
    public static void dfs(int[] nums, int dep, int n, int sum, int x, int index){
        if(dep == n){
            if(sum >= x){
                res++;
            }
            return;
        }
        for(int i = index; i < nums.length; i++){
            sum += nums[i];
            dfs(nums, dep+1, n, sum, x, index+1);
            sum -= nums[i];
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            res = 0;
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            boolean[] visit= new boolean[n];
            dfs(nums, 0, (int)((n + 1) / 2), 0, x, 0);
            System.out.println(res);
        }
    }
}
