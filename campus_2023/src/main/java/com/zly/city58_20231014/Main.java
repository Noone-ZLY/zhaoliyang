package com.zly.city58_20231014;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/14 19:33
 */
public class Main {
    public static int[] intersectionAndSort (int[] docList1, int[] docList2) {
        // write code here
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet<>();
        for(int num : docList1){
            set1.add(num);
        }
        for(int num : docList2){
            set2.add(num);
        }
        set1.retainAll(set2);
        Integer[] ans = set1.toArray(new Integer[0]);
        Arrays.sort(ans, (Integer a, Integer b) -> (b-a));
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}
