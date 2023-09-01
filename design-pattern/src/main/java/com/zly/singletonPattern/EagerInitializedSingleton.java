package com.zly.singletonPattern;

import java.util.logging.Logger;


public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton(){}
    public static EagerInitializedSingleton getEagerInitializedSingleton(){
        return instance;
    }
}
