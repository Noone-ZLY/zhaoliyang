package com.zly.tengxunyinyue_20230922;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/22 19:01
 */
public class Main {
    public static int fun(int n){
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = chars.length - 1; i >= 0; --i){
            if(chars[i] == '5' || chars[i] == '0'){
                return res;
            }
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fun(n));
    }
}
