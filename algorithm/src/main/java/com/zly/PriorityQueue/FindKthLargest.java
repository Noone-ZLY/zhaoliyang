package com.zly.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/25 13:02
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for(int num : nums){
            queue.add(num);
        }
        while(k-- > 1){
            queue.poll();
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(findKthLargest(nums, k));
    }
}
