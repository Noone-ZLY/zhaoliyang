package com.zly.singletonPattern;

import java.util.logging.Logger;

/**
 * @author zhaoliyang9
 * @des 饿汉式单例模式
 * @date 2023/8/11 16:53
 **/
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    private EagerInitializedSingleton(){}
    public static EagerInitializedSingleton getEagerInitializedSingleton(){
        return instance;
    }
}
