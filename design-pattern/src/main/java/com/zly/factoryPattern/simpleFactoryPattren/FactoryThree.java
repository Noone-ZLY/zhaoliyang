package com.zly.factoryPattern.simpleFactoryPattren;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/18 13:44
 **/
public class FactoryThree implements FactoryClass{
    private String factoryName;

    public FactoryThree(){}
    public FactoryThree(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
