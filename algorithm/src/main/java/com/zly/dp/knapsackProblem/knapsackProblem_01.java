package com.zly.dp.knapsackProblem;

import java.util.*;

/**
 * @author zhaoliyang9
 * @date 2023/8/6 15:39
 * @des 0-1背包问题
 * 最基本的背包问题就是01背包问题（01 knapsack problem）：一共有N件物品，
 * 第i（i从1开始）件物品的重量为w[i]，价值为v[i]。在总重量不超过背包承载上限W的情况下，
 * 能够装入背包的最大价值是多少？
 **/
public class knapsackProblem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        Map<String, Integer> stringHashMap = new HashMap<>();
        for(String word:words){
            if(stringHashMap.containsKey(word)){
                stringHashMap.put(word, stringHashMap.get(word) + 1);
            }else{
                stringHashMap.put(word, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(stringHashMap.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                if(res == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return res;
            }
        });
        for(Map.Entry<String, Integer> entry: list){
            if(entry.getValue() >= 3){
                System.out.println(entry.getKey());
            }
        }
    }
}
