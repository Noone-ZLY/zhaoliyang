package com.zly.subSequece;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : 子序列相关题目
 * @createDate : 2023/9/18 14:36
 */
public class SubSequence {

    /**
     * @param [num]
     * @return java.lang.String
     * @description Leetcode-2264. 字符串中最大的 3 位相同数字
     * @author zhaoliyang
     * @create 2023/9/18 14:37
     */
    public static String largestGoodInteger(String num) {
        int min = Integer.MIN_VALUE;
        String ans = "";
        for(int i = 0; i < num.length()-2; ++i){
            String substring = num.substring(i, i + 3);
//            System.out.println(substring);
            if(substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)){
                if(Integer.valueOf(substring).intValue() > min){
                    min = Integer.valueOf(substring).intValue();
                    ans = substring;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(largestGoodInteger(str));
    }
}
