package com.zly.jinshan_20230924;

import java.util.List;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/24 19:44
 */
public class Main {
    public static boolean search(char ch, char[] yuan){
        int left = 0, right = yuan.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(ch == yuan[mid]){
                return true;
            }else if(ch < yuan[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        char[] yuan = {'a', 'e', 'i', 'o', 'u'};
        int y = 0, f = 0;
        for (int i = 0; i < chars.length; i++) {
            if(search(chars[i], yuan)){
                y++;
            }
        }
        f = chars.length - y;
//        System.out.println(y + " " + f);
        System.out.println(f <= 2 * y - 1 ? (y + f) : (y + (2 * y - 1)));
    }
}
