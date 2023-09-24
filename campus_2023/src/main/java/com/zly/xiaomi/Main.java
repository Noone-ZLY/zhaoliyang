package com.zly.xiaomi;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/23 16:45
 */
public class Main {
    public static  double len(int[] pos1, int [] pos2){
        int abs = Math.abs(pos1[0] - pos2[0]);
        int abs1 = Math.abs(pos1[1] - pos2[1]);
        return Math.sqrt(Math.pow(abs, 2) + Math.pow(abs1, 2));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] split = firstLine.split(",");
        int n = Integer.valueOf(split[0]);
        int radius = Integer.valueOf(split[1]);
        int[][] pos = new int[n][3];
        int[] pow = new int[n];
        double[] res = new double[n];
        Arrays.fill(res, 0);
        for(int i = 0; i < n; i++){
            String line = scanner.nextLine();
            String[] split1 = line.split(",");
            pos[i][0] = Integer.valueOf(split1[0]);
            pos[i][1] = Integer.valueOf(split1[1]);
            pos[i][2] = Integer.valueOf(split1[2]);
        }
        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        for(int i = 0; i < n; i++){
//            System.out.println(pos[i][0] + " " + pos[i][1]);
            pow[i] = pos[i][2];
        }
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    sum += pow[j];
                }else{
                    double d = len(pos[i], pos[j]);
                    if(d <= radius){
                        sum += (pow[j] / (1 + d));
                    }
                }
            }
            res[i] = sum;
        }
        double asInt = Arrays.stream(res).max().getAsDouble();
        for(int i = 0; i < n; i++){
            if(res[i] == asInt){
                System.out.println(pos[i][0] + "," + pos[i][1]);
                return;
            }
        }
    }
}
