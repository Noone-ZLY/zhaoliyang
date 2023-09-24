package com.zly.kedaxunfei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/9 14:33
 * @description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Map<Long, Integer> hashmap = new HashMap<>();

        long[] nums = new long[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextLong();
            Long key = Long.valueOf(nums[i]);
            hashmap.put(key, hashmap.getOrDefault(key, 0) + 1);
        }
        for(Map.Entry entry : hashmap.entrySet()){
            if(entry.getValue() == Integer.valueOf(b)){
                System.out.println(entry.getKey());
            }
        }
    }
}
