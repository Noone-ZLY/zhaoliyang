package com.zly.xiaohongshu_20230806;

import java.util.Scanner;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/6 13:40
 **/
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            String[] s = input.split(" ");
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            double ans = 0;
            double cur = n;
            while(m-- > 0){
                ans += cur;
                cur = Math.sqrt(cur);
            }
            System.out.format("%.2f%n", ans);
        }
    }
}
