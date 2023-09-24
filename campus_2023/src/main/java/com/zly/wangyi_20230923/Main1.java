package com.zly.wangyi_20230923;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 14:02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> hashmap = new HashMap<>();
        int[] words = new int[26];
        while(n-- > 0){
            char[] chars = scanner.next().toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            System.out.println(key);
            hashmap.put(key, hashmap.getOrDefault(key, 0) + 1);
        }
        long ans = 0;
        for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
            if(entry.getValue() > 1){
                ans += (long)(entry.getValue() * (entry.getValue() - 1)) / 2;
            }
        }
        System.out.println(ans);
    }

}

