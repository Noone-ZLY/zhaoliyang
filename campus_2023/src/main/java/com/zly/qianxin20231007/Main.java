package com.zly.qianxin20231007;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/7 18:31
 */
public class Main {
    public static boolean fun(int[] p, int[] s, int i){
        if(i >= 0){
            for(int ii = 0; ii < 4; ii++){
                if(s[i] >= p[i]){
                    s[i] -= p[i];
                    if(fun(p, s, i - 1)){
                        return true;
                    }
                    s[i] += p[i];
                }
            }
        }else{
            return true;
        }
        return false;
    }
    public boolean CheckSquare (int[] planks) {
        // write code here
        int n = planks.length;
        int sum = Arrays.stream(planks).sum();
        if(sum % 4 != 0){
            return false;
        }
        if(Arrays.stream(planks).max().getAsInt() > sum / 4){
            return false;
        }
        int[] s = new int[4];
        Arrays.fill(s, sum / 4);
        Arrays.sort(s);
        Arrays.sort(planks);
        return fun(planks,s, 0);
    }
    public static void main(String[] args) {

    }
}
