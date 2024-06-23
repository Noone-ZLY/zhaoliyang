package com.zly;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/19 19:40
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[m];
        for(int i = 0; i < m; i++){
            nums[i] = in.nextInt();
        }
        int[] pre = new int[m];
        int[] bck = new int[m];
        pre[0] = nums[0];
        bck[0] = nums[m - 1];
        for(int i = 1; i < m - n; i++){
            System.out.println(pre[i] + " " + pre[i-1]);
            pre[i] = nums[i] + pre[i-1];
            bck[i] = nums[m-i-1] + bck[i-1];
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(bck));
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            int left = 0, right = 0;
            if(i > 0){
                left = pre[i];
            }
            if(i + n < m - 1){
                right = bck[m - n - i -1];
            }
            ans = Math.max(ans, left + right);
        }
        System.out.println(ans);
    }
}
