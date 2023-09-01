package com.zly.thisTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/15 11:01
 **/
public class ThisTest {
    private String name;
    ThisTest(String name){
        System.out.println(this);
    }
}

class Test{
    public static void main(String[] args) {
        ThisTest thisTest = new ThisTest("zly");
    }
}
