package com.zly.subSequece;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description : LeetCode-521:最长特殊序列
 * @createDate : 2023/9/18 14:24
 */
public class FindLUSlength {

    public static int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(findLUSlength(str1, str2));
    }
}
