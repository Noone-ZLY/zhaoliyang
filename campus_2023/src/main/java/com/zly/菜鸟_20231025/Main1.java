package com.zly.菜鸟_20231025;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/25 19:50
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            if (checkIfAllElementsCanBeEqual(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkIfAllElementsCanBeEqual(int[] a) {
        // 检查奇偶性是否相同
        boolean allEven = true;
        boolean allOdd = true;
        for (int num : a) {
            if (num % 2 == 0) {
                allOdd = false;
            } else {
                allEven = false;
            }
        }

        if (allEven || allOdd) {
            return true;
        }

        // 分别检查偶数和奇数的情况
        boolean canEqualEven = true;
        boolean canEqualOdd = true;

        for (int num : a) {
            if (num % 2 == 0) {
                // 检查能否通过操作变为相等的偶数值
                while (num % 2 == 0) {
                    num /= 2;
                }
                if (num != a[0]) {
                    canEqualEven = false;
                    break;
                }
            } else {
                // 检查能否通过操作变为相等的奇数值
                while (num % 2 == 1) {
                    num--;
                }
                if (num != a[0]) {
                    canEqualOdd = false;
                    break;
                }
            }
        }

        return canEqualEven || canEqualOdd;
    }
}

