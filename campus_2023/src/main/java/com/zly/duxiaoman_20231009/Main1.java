package com.zly.duxiaoman_20231009;

import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/9 20:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
            }
            boolean sorted = true;
            for(int j = 0; j < n-1; j++){
                if(a[j] > a[j+1]){
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                System.out.println(0);
                continue;
            }
            int p = 0;
            for(int i = 0; i < m; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if(a[x-1] > a[y-1]){
                    int temp = a[x-1];
                    a[x-1] = a[y-1];
                    a[y-1] = temp;
                }
                sorted = true;
                for(int j = 0; j < n-1; j++){
                    if(a[j] > a[j+1]){
                        sorted = false;
                        break;
                    }
                }
                if(sorted){
                    p = i + 1;
                    break;
                }
            }
            System.out.println(p);
        }
    }
}
