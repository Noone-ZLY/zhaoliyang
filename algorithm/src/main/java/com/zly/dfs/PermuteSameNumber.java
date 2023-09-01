package com.zly.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/24 18:06
 **/
public class PermuteSameNumber {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    public static void dfs(int[] nums, boolean[] visited, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && !visited[i] && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, depth+1);
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        dfs(nums, visited, 0);
        System.out.println(res.toString());
    }
}
