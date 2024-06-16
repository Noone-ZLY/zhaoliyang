package com.zly.mayijingfu;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 输入数组的元素个数
        int[] nums = new int[n];  // 输入数组
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = countWWuYuanZu(nums);
        System.out.println(result);
    }

    public static int countWWuYuanZu(int[] nums) {
        int n = nums.length;
        int count = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {  // 第一个数大于第二个数
                    for (int k = j + 1; k < n; k++) {
                        for(int l = k + 1;l < n;l++){
                            if (nums[j] == nums[l]){
                                for(int m = l + 1;m < n;m++){
                                    if(nums[i] == nums[k] && nums[i] == nums[m]){
                                        count++;
                                        count %= mod;

                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return count;
    }
}