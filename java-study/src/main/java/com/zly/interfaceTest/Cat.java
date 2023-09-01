package com.zly.interfaceTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 18:20
 **/
public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Cat can eat.");
    }
    @Override
    public void walk() {
        System.out.println("Cat can walk.");
    }
}
