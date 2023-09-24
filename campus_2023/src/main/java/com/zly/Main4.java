package com.zly;

import java.util.Scanner;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 20:21
 * @description :
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] YRow = new int[n];
        int[] YCol = new int[m];
        int[] ORow = new int[n];
        int[] OCol = new int[m];
        int[] URow = new int[n];
        int[] UCol = new int[m];

        char[][] matrix = new char[n][m];
        for(int i = 0; i < n; i++){
            matrix[i] = scanner.next().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 'y'){
                    ++YRow[i];
                    ++YCol[j];
                } else if (matrix[i][j] == 'o') {
                    ++ORow[i];
                    ++OCol[j];
                } else if (matrix[i][j] == 'u') {
                    ++URow[i];
                    ++UCol[j];
                }
            }
        }
        long res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 'y'){
                    res += ORow[i] * UCol[j] + OCol[j] * URow[i];
                } else if (matrix[i][j] == 'o') {
                    res += YRow[i] * UCol[j] + YCol[j] * URow[i];
                } else if (matrix[i][j] == 'u'){
                    res += YRow[i] * OCol[j] + YCol[j] * ORow[i];
                }
            }
        }
        System.out.println(res);
    }
}
