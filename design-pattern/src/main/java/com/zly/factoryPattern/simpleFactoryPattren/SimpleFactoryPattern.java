package com.zly.factoryPattern.simpleFactoryPattren;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/18 13:42
 **/
public class SimpleFactoryPattern {
    public FactoryClass createFactory(String name){
        FactoryClass factory = null;
        if (name.equals("one")){
            return new FactoryOne();
        } else if (name.equals("two")) {
            return new FactoryTwo();
        } else if (name.equals("three")) {
            return new FactoryThree();
        }
        return null;
    }
}
