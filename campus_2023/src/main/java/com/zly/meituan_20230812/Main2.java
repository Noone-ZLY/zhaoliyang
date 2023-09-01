package com.zly.meituan_20230812;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/12 10:11
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int min_p = x <= y ? x : y;
        int max_p = min_p == x ? y : x;

        long ans1 = 0L;
        long ans2 = 0L;
        for(int i = min_p - 1; i < max_p; i++){
            ans1 += (long)nums[i];
        }
        for(int i = max_p - 1; i < n; i++){
            ans2 += (long)nums[i];
        }
        for(int i = 0; i < min_p - 1; i++){
            ans2 += (long)nums[i];
        }
        System.out.println(ans1 + " " + ans2);
        if(ans1 <= ans2){
            System.out.println(ans1);
        }else{
            System.out.println(ans2);
        }
    }
}
