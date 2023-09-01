package com.zly.upCastingAndDownCasting;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 18:04
 **/
public class Bird extends Animal{
    @Override
    void eat(){
        System.out.println("Bird can eat.");
    }
    void fly(){
        System.out.println("Bird can fly.");
    }
}
