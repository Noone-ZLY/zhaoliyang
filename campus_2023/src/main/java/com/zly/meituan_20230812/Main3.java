package com.zly.meituan_20230812;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/12 10:22
 **/
public class Main3 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        long[] sum_col = new long[m];
        for(int j = 0; j < m; j++){
            long sum = 0;
            for(int i = 0; i < n; i++){
                sum += nums[i][j];
            }
            sum_col[j] = sum;
        }
        long min_res = Long.MAX_VALUE;
        for(int i = 1; i < m; i++){
            sum_col[i] += sum_col[i-1];
        }
        for(int i = 0; i < m-1; i++){
            long num = Math.abs(sum_col[m-1] - sum_col[i] * 2);
            min_res = num <= min_res ? num : min_res;
        }
        System.out.println(min_res);

        long[] sum_row = new long[n];
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = 0; j < n; j++){
                sum += nums[i][j];
            }
            sum_row[i] = sum;
        }
        long min_res_1 = Long.MAX_VALUE;
        for(int i = 1; i < n; i++){
            sum_row[i] += sum_row[i-1];
        }
        for(int i = 0; i < n-1; i++){
            long num = Math.abs(sum_row[n-1] - sum_row[i] * 2);
            min_res_1 = num <= min_res_1 ? num : min_res_1;
        }
        System.out.println(min_res_1);
        if(min_res < min_res_1){
            System.out.println(min_res);
        }else {
            System.out.println(min_res_1);
        }
    }
}
