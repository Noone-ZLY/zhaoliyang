package com.zly.yongyou;

import com.zly.Main;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/18 19:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
            }
        }
        System.out.println(nums[n][m]);
    }
}
