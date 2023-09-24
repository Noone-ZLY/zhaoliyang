package com.zly.kedaxunfei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/9 14:43
 * @description :
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.next();
        char[] chars = words.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        int num = 0;
        while(i < chars.length && j < chars.length){
            if(chars[i] == chars[j]){
                num++;
                j++;
            }else{
                sb.append(String.valueOf(num) + String.valueOf(chars[i]));
                num = 0;
                i = j;
            }
        }
        sb.append(String.valueOf(num) + String.valueOf(chars[chars.length-1]));
        System.out.println(sb.toString());
    }
}
