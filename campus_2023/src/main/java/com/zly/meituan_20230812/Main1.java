package com.zly.meituan_20230812;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/12 10:01
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        for(int i = 0; i < n; i++){
            if(nums[i] == x){
                if(i - 1 >= 0 && i+1 < n && (nums[i-1] == y || nums[i+1] == y)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
