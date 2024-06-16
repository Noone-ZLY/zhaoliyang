package com.zly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 20:21
 * @description :[0, 1, 2, 3] target = 3
 */
class Worker implements Runnable{
    String name;
    public Worker(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("i am " + name);
    }
}

public class Main4 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> temp = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        int[] nums = {0, 1, 2, 3};
        int target = 3;
        dfs(nums, 0, target, 0);
        for(List<Integer> list : res){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void dfs(int[] nums, int sum, int target, int index){
        if(sum == target && temp.size() >= 2){
            res.add(new ArrayList<>(temp));
        }
        if(sum > target){
            return;
        }
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            dfs(nums, sum+nums[i], target, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
