package com.zly.hot100;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description : 字母异位词分组
 * @createDate : 2023/10/6 14:57
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = String.valueOf(letters);
            List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }
}
