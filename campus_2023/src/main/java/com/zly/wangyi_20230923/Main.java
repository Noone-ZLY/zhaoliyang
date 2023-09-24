package com.zly.wangyi_20230923;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 14:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        while (times-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            if (n % 2 == 1) {
                System.out.println("YES");
            } else {
                boolean flag = true;
                int[] nums1 = new int[n / 2];
                int[] nums2 = new int[n / 2];
                int k1 = 0;
                int k2 = 0;
                for (int i = 0; i < n; i += 2) {
                    nums1[k1++] = nums[i];
                }
                for (int i = 1; i < n; i += 2) {
                    nums2[k2++] = nums[i];
                }
                Arrays.sort(nums1);
                Arrays.sort(nums2);
                for (int i = 0; i < nums1.length; i++) {
                    if(nums1[i] > nums2[i]){
                        flag = false;
                    }
                }
                System.out.println(flag == true ? "YES" : "NO");
            }
        }
    }
}
