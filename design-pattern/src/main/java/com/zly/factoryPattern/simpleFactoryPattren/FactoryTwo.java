package com.zly.factoryPattern.simpleFactoryPattren;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/18 13:44
 **/
public class FactoryTwo implements FactoryClass{
    private String factoryName;

    public FactoryTwo(){}
    public FactoryTwo(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
