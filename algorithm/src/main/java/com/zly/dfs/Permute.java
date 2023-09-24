package com.zly.dfs;

import java.util.*;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/23 20:09
 **/
public class Permute {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> part = new ArrayList<>();

    public static void dfs(int[] nums, boolean[] visited, int i, int m) {
        if(part.size() == m){
            res.add(new ArrayList<>(part));
        }
        for(int j = i; j < nums.length; j++){
            if(visited[j]){
                continue;
            }
            part.add(nums[j]);
            visited[j] = true;
            dfs(nums, visited, j, m);
            visited[j] = false;
            part.remove(part.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int ans = 0;
            res = new ArrayList<>();
            part = new ArrayList<>();
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            boolean[] visited = new boolean[n];
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            int m = (int) ((n + 1) / 2);

            dfs(nums, visited, 0, m);

            for (List<Integer> list : res) {
                if (list.stream().mapToInt(Integer::intValue).sum() >= x) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
