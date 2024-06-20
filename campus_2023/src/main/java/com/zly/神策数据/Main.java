package com.zly.神策数据;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/31 18:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] price1 = scanner.nextLine().split(" ");
        String[] price2 = scanner.nextLine().split(" ");
        String money = scanner.nextLine();
        int[] p1 = new int[price1.length];
        int[] p2 = new int[price2.length];
        int m = Integer.valueOf(money);
        int temp = m;
        for(int i = 0; i < price1.length; i++){
            p1[i] = Integer.valueOf(price1[i]);
        }
        for(int i = 0; i < price2.length; i++){
            p2[i] = Integer.valueOf(price2[i]);
        }
        Arrays.sort(p1);
        Arrays.sort(p2);
        int ans = 0;
        for(int i = 0; i < p1.length; i++){
            if(p1[i] <= m){
                ans++;
            }else {
                break;
            }
        }
        for(int i = 0; i < p2.length; i++){
            if(p2[i] <= m){
                ans++;
            }else {
                break;
            }
        }
        for(int i = 0; i < p1.length; i++){
            m = temp;
            if(p1[i] <= m){
                m -= p1[i];
            }else {
                break;
            }
            for(int j = 0; j < p2.length; j++){
                if(p2[j] <= m){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
