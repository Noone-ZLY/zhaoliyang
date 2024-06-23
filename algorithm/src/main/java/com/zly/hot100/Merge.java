package com.zly.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhaoliyang
 * @description : 合并区间
 * @createDate : 2023/10/12 14:01
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] interval : intervals){
            Arrays.sort(interval);
        }
        Arrays.sort(intervals, (int[] a, int[] b)->(a[0]- b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > end){
                res.add(new ArrayList<>(Arrays.asList(start, end)));
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                if(intervals[i][0] >= start && intervals[i][1] <= end){
                    continue;
                }
                if(intervals[i][0] >= start && intervals[i][0] <= end && intervals[i][1] > end){
                    end = intervals[i][1];
                }
            }
        }
        res.add(new ArrayList<>(Arrays.asList(start, end)));
        return res.stream().map(list ->
            list.stream().mapToInt(e -> e).toArray()).toArray(int[][]::new);
    }

    public static void main(String[] args) {

    }
}
