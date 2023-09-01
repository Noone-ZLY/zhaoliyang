package com.zly.factoryPattern.simpleFactoryPattren;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/18 13:55
 **/
public class SimpleFactoryPatternTest {
    public static void main(String[] args) {
        FactoryClass one = new SimpleFactoryPattern().createFactory("one");
        FactoryClass two = new SimpleFactoryPattern().createFactory("two");
        FactoryClass three = new SimpleFactoryPattern().createFactory("three");
    }
}
