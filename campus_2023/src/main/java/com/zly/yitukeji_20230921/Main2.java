package com.zly.yitukeji_20230921;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/21 19:00
 */
public class Main2 {
    public static int fun(int[][] maxtrix){
        int rows = maxtrix.length;
        int cols = maxtrix[0].length;

        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        for(int col = 1; col < cols; col++){
            for(int pre = 0; pre < col; ++pre){
                boolean isValid = true;

                for(int row = 0; row < rows; row++){
                    if(maxtrix[row][col] < maxtrix[row][pre]){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    dp[col] = Math.max(dp[col], dp[pre] + 1);
                }
            }
        }
        int asInt = Arrays.stream(dp).max().getAsInt();
        int min = cols - asInt;
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println(fun(nums));
    }
}
