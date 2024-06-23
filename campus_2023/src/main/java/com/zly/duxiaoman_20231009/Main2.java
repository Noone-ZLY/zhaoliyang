package com.zly.duxiaoman_20231009;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/9 19:27
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for(int key : b){
            counts.put(key, counts.getOrDefault(b, 0) + 1);
        }
        int l  = 0, r = -1;
        int counter = counts.size();
        int minL = -1;
        int minLen = Integer.MAX_VALUE;
        while(r < n - 1){
            r++;
            if(counts.containsKey(a[r])){
                counts.put(a[r], counts.get(a[r]) - 1);
                if(counts.get(a[r]) == 0){
                    counter--;
                }
            }
            while(counter == 0){
                int len = r - l + 1;
                if(len < minLen){
                    minLen = len;
                    minL = l;
                }
                if(counts.containsKey(a[l])){
                    counts.put(a[l], counts.get(a[l])+1);
                    if(counts.get(a[l]) == 1){
                        counter++;
                    }
                }
                l++;
            }
        }
        if(minL == -1){
            System.out.println(-1);
        }else{
            System.out.println(minLen);
        }
    }
}
