package com.zly.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/30 14:21
 **/
public class DictionaryIndexSort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 6, 5, 11, 21};
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s = o1.toString();
                String s1 = o2.toString();
                return s1.compareTo(s);
            }
        });
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }
    }

}