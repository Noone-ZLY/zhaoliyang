package com.zly.yongyou;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/18 20:03
 */
public class Main {
    public ArrayList<Integer> findAllPerson (int n, int[][] meetings, int firstPerson) {
        // write code here
        int[] people = new int[n];
        people[0] = 1;
        people[firstPerson] = 1;
        Map<Integer, List<Integer>> hashmap = new TreeMap<>();
        for (int i = 0; i < meetings.length; i++){
            Integer key = Integer.valueOf(meetings[i][2]);
            List<Integer> list = hashmap.containsKey(key) ? hashmap.get(key) : new ArrayList<>();
            list.add(Integer.valueOf(meetings[i][0]));
            list.add(Integer.valueOf(meetings[i][1]));
            hashmap.put(key, list);
        }
        for(Map.Entry<Integer, List<Integer>> entry : hashmap.entrySet()){
            for(Integer num : entry.getValue()){
                if(people[num.intValue()] == 1){
                    for(Integer num1 : entry.getValue()){
                        people[num1.intValue()] = 1;
                    }
                    break;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if(people[i] == 1){
                ans.add(Integer.valueOf(i));
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
