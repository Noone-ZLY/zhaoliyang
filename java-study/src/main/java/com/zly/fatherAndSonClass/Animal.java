package com.zly.fatherAndSonClass;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/28 18:32
 **/
public class Animal {
    private String name;
    private int age;
    private int height;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name, int age, int height) {
        this(name, age);
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}
