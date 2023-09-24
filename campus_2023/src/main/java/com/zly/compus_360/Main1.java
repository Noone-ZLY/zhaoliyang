package com.zly.compus_360;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 18:41
 */
public class Main1 {
    public static int cal(String s){
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        char pre = '+';
        int num = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n-1){
                switch (pre){
                    case '+':
                        integers.push(num);
                        break;
                    case '-':
                        integers.push(-num);
                        break;
                    case '*':
                        integers.push(integers.pop() * num);
                        break;
                    default:
                        integers.push(integers.pop() / num);
                }
                pre = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while(!integers.isEmpty()){
            ans += integers.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String str = scanner.next();
            StringBuilder sb = new StringBuilder(str);
            boolean flag = false;
            for(int j = 0; j <= sb.length(); j++){
                for(int k=  0; k <= 9; k++){
                    sb.insert(j, k);
                    String[] spilt = sb.toString().split("=");
                    if(cal(spilt[0]) == cal(spilt[1])){
                        flag = true;
                        break;
                    }
                    sb.deleteCharAt(j);
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
