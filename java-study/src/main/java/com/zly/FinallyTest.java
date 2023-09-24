package com.zly;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/21 10:47
 */
public class FinallyTest {
    public static int finallyTest(){
        try{
            System.out.println(0 / 0);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(finallyTest());
    }
}
