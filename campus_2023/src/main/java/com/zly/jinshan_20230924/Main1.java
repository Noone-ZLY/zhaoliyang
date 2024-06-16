package com.zly.jinshan_20230924;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/24 20:14
 */
public class Main1 {
    public static void main(String[] args) {
        int[] ai = {5, 4, 3, 2, 1}; // 球员的能力值数组
        int n = ai.length; // 球员人数
        int m = 2; // 每位教练一次选择的人数

        List<Integer> team1 = new ArrayList<>(); // 第一支队伍
        List<Integer> team2 = new ArrayList<>(); // 第二支队伍

        // 对球员的能力值数组进行降序排序
        Integer[] sortedAi = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedAi[i] = ai[i];
        }
        Arrays.sort(sortedAi, Collections.reverseOrder());

        // 模拟教练轮流选择球员的过程
        boolean coach1Turn = true; // 记录当前是第一个教练的轮次还是第二个教练的轮次
        for (int i = 0; i < n; i++) {
            // 选择能力值最大的球员
            int selectedPlayer = sortedAi[i];

            // 将选中的球员加入对应队伍的成员列表中
            if (coach1Turn) {
                team1.add(selectedPlayer);
            } else {
                team2.add(selectedPlayer);
            }

            // 移除该球员及其左右两侧的 m 个人（或尽可能多的人）
            int index = Arrays.asList(ai).indexOf(selectedPlayer);
            int startIndex = Math.max(index - m, 0);
            int endIndex = Math.min(index + m, n - 1);
            for (int j = startIndex; j <= endIndex; j++) {
                sortedAi[i] = -1; // 将已选中的球员的能力值设置为 -1，标记为已选
            }

            // 切换教练的轮次
            coach1Turn = !coach1Turn;
        }

        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
    }
}
