package com.zly.interfaceTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 18:20
 **/
public class Dog implements Animal{
    @Override
    public void eat() {
        Animal.super.eat();
    }

    @Override
    public void walk() {

    }
}
