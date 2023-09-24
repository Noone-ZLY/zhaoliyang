package com.zly.subSequece;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/18 13:09
 */
public class IsSubSequence {
    /**
     * @param [s, t]
     * @return boolean
     * @description 求字符串s是否为t的子串
     * @author zhaoliyang
     * @create 2023/9/18 13:27
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        System.out.println(s.length() + " " + t.length());
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }
        return false;
    }

    public static boolean isSubsequenceByDP(String s, String t){
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                }
                else{
                    f[i][j] = f[i + 1][j];
                }

            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sonString = scanner.next();
        String motherString = scanner.next();
        System.out.println(isSubsequenceByDP(sonString, motherString));
    }
}
