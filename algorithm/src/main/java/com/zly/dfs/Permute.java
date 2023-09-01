package com.zly.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/23 20:09
 **/
public class Permute {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> part = new ArrayList<>();

    public static void dfs(int[] nums, boolean[] visited, int i) {
        if(part.size() == nums.length){
            res.add(new ArrayList<>(part));
        }
        for(int j = 0; j < nums.length; j++){
            if(visited[j]){
                continue;
            }
            part.add(nums[j]);
            visited[j] = true;
            dfs(nums, visited, j);
            visited[j] = false;
            part.remove(part.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] visited = new boolean[n];
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        dfs(nums, visited, 0);
        System.out.println(res.toString());
    }
}
