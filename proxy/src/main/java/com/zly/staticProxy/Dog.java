package com.zly.staticProxy;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:10
 **/
public class Dog implements Animal{
    @Override
    public void talk(String msg) {
        System.out.println("Dog:" + msg);
    }
}
