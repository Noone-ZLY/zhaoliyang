package com.zly.meituan_20230812;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/12 10:57
 **/
public class Main4 {
    public static final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String words = scanner.next();
        char[] chars = words.toCharArray();
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt((double) n); i++){
            int res = 0;
            if(n % i != 0){
                continue;
            }
            int row = i;
            int col = (int) (n / i);
            char[][] arrays = splitArray(chars, row, col);
            boolean[][] flag = new boolean[row][col];
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    if(!flag[r][c]){
                        res++;
                    }
                    compute(arrays, flag, r, c);
                }
            }
            ans = res < ans ? res : ans;
        }
        System.out.println(ans);
    }

    public static char[][] splitArray(char[] chars, int row, int col){
        int k = 0;
        char[][] res = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res[i][j] = chars[k++];
            }
        }
        return res;
    }

    public static void compute(char[][] chars, boolean[][] flag, int r, int c){
        flag[r][c] = true;
        if(r < 0 || r >= chars.length || c < 0 || c >= chars[0].length){
            return;
        }
        for(int[] d : direct){
            int x = r + d[0];
            int y = c + d[1];
            if(x < 0 || x >= chars.length || y < 0 || y >= chars[0].length || flag[x][y] || chars[x][y] != chars[r][c]){
                continue;
            }
            compute(chars, flag, x, y);
        }
    }
}
