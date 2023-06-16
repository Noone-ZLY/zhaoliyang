package com.zly.dynamicProxy;

import com.zly.staticProxy.Animal;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:43
 **/
public class DynamicProxyTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        DynamicProxy dynamicProxy = new DynamicProxy();

        dynamicProxy.setAnimal(dog);
        Animal animalDog = (Animal)dynamicProxy.getProxyInstance();
        animalDog.talk("汪汪汪");

        dynamicProxy.setAnimal(cat);
        Animal animalCat = (Animal) dynamicProxy.getProxyInstance();
        animalCat.talk("喵喵喵");

        Rose rose = new Rose();
        dynamicProxy.setAnimal(rose);
        Flower flower = (Flower) dynamicProxy.getProxyInstance();
        flower.open();

    }
}
