package com.zly.jinshan_20230924;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/24 20:03
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int t = x;
        int mod = (int)(1e9 + 7);
        int res = 0;
        while(n-- > 0){
            int k = scanner.nextInt();
            res += (k * x) % mod;
            x *= t;
        }
        System.out.println(res);
    }
}
