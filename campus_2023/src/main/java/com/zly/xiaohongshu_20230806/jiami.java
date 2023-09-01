package com.zly.xiaohongshu_20230806;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/6 14:14
 **/
public class jiami {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String words = scanner.next();
        String ans = "";
        char[] letters = words.toCharArray();
        for(char letter : letters){
            System.out.println((int) letter);
            ans += letter >= 100 ? (char)(letter - 3) : (char)(letter + 23);
        }
        System.out.println(ans);
    }
}
