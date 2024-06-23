package com.zly.qianxin20231007;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/7 18:31
 */


class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


public class Main1 {
    public ArrayList<Point> maxIncomeProducts (ArrayList<Point> products, int months) {
        // write code here
        int[] dp = new int[months + 1];
        List<ArrayList<Point>> list = new ArrayList<>();
        for(int i =0; i <= months; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1; i <= months; i++){
            for(Point product : products){
                int month = product.x;
                int profit = product.y;
                if(month <= i && dp[i - month] + profit > dp[i]){
                    list.set(i, new ArrayList<>(list.get(i - month)));
                    list.get(i).add(product);
                }
            }
        }
        ArrayList<Point> points = list.get(months);
        Collections.sort(points, Comparator.comparing(p -> p.x));
        return points;
    }
    public static void main(String[] args) {

    }
}
