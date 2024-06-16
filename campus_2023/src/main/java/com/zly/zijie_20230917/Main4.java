package com.zly.zijie_20230917;
import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和人数k
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 读取三个数组a1, a2, a3
        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            arrays.add(array);
        }

        // 计算按位或的最大结果
        int maxOrResult = computeMaxOrResult(n, k, arrays);

        // 输出结果
        System.out.println(maxOrResult);
    }

    private static int computeMaxOrResult(int n, int k, List<int[]> arrays) {
        // 记录每个数组的前缀的按位或操作结果
        List<Integer> prefixList = new ArrayList<>();

        // 对于每个数组，计算所有前缀的按位或操作结果
        for (int[] array : arrays) {
            int prefixOrResult = 0;
            for (int i = 0; i < n; i++) {
                prefixOrResult |= array[i];
                prefixList.add(prefixOrResult);
            }
        }

        // 找出列表中按位或结果最大的k个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : prefixList) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // 计算按位或结果的最大值
        int maxOrResult = 0;
        for (int num : maxHeap) {
            maxOrResult |= num;
        }

        return maxOrResult;
    }
}