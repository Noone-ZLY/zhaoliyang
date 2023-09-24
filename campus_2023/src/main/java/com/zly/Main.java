package com.zly;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if((n+m) % 2 == 0){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}