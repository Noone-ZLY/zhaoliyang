package com.zly.staticProxy;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:16
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        StaticProxy staticProxy = new StaticProxy(dog);

        staticProxy.talk("汪汪汪");
    }
}
