package com.zly.dipingxian;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 19:10
 */
public class Main2 {
    public static String compressString (String param) {
        // write code here
        int n = param.length();
        if(n == 1){
            return param;
        }
        int i = 0, j = 0;
        String res = "";
        while(i < n && j < n){
            if(param.charAt(i) == param.charAt(j)){
                j++;
            }else{
                res += String.valueOf(param.charAt(i));
                if(j - i > 1){
                    res += (j - i);
                }
                i = j;
            }
        }
        res += String.valueOf(param.charAt(i));
        if(j - i > 1){
            res += (j - i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(compressString(str));
    }
}
