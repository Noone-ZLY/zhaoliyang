package com.zly.AbstractClassTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/28 18:11
 **/
public class Cat extends AbstractAnimalClass{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        System.out.println("Cat can walk.");
    }

    @Override
    protected void eat() {
        System.out.println("Cat can eat.");
    }

}
