package com.zly.dynamicProxy;

import com.zly.staticProxy.Animal;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:34
 **/
public class Dog implements Animal {
    @Override
    public void talk(String msg) {
        System.out.println("Dog talk:" + msg);
    }
}
