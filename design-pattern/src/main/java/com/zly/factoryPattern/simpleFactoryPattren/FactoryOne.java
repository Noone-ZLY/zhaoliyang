package com.zly.factoryPattern.simpleFactoryPattren;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/18 13:44
 **/
public class FactoryOne implements FactoryClass{
    private String factoryName;

    public FactoryOne(){}
    public FactoryOne(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
