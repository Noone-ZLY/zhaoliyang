package com.zly.subSequece;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : LeetCode-459:重复的字符字串
 * @createDate : 2023/9/18 13:47
 */
public class RepeatedSubStringPattern {
    public static boolean repeatedSubstringPatternByEnum(String s) {
        int n = s.length();
        for(int i = 1; i * 2 <= n; ++i){
            if(n % i == 0){
                boolean match = true;
                for(int j = i; j < n; ++j){
                    if(s.charAt(j) != s.charAt(j - i)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPatternByStringFunc(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(repeatedSubstringPatternByStringFunc(str));
    }
}
