package com.zly.duxiaoman_20231009;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/9 19:04
 */
public class Main {
    private static String key = "accept";
    private static Boolean ans = false;
    public static void dfs(char[][] words, boolean[][] visited, int i, int j, int index){
        if(i < 0 || i >= words.length || j < 0 || j >= words[0].length || words[i][j] != key.charAt(index)){
            return;
        }
        if(index == key.length()-1 && words[i][j] == key.charAt(index)){
            ans = true;
            return;
        }
        visited[i][j] = true;
        dfs(words, visited,i+1, j, index+1);
        dfs(words, visited, i, j+1, index+1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            ans = false;
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            char[][] words = new char[row][col];
            for(int i = 0; i < row; i++){
                words[i] = scanner.next().toCharArray();
            }
            boolean[][] visited = new boolean[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(visited[i][j] == false){
                        dfs(words, visited, i, j, 0);
                    }
                }
            }
            if(ans){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}