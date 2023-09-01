package com.zly.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/24 18:51
 **/
public class PermuteString {
    private static List<String> res = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void dfs(char[] chars, boolean[] visited, int depth){
        if(depth == chars.length){
            res.add(sb.toString());
        }
        for(int i = 0; i < chars.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && chars[i] == chars[i-1] && !visited[i] && !visited[i-1]){
                continue;
            }
            sb.append(chars[i]);
            visited[i] = true;
            dfs(chars, visited, depth+1);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Arrays.sort(chars);
        dfs(chars, visited, 0);
        System.out.println(res.toString());
    }
}
