package com.zly.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/12 13:21
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n < m){
            return res;
        }
        char[] chars1 = p.toCharArray();
        Arrays.sort(chars1);
        p = String.valueOf(chars1);
        for(int i = 0; i <= n - m; i++){
            String substring = s.substring(i, i + m);
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);
            String s1 = String.valueOf(chars);
            if(s1.equals(p)){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(s.length() + " " + p.length());
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams.toString());
    }
}
