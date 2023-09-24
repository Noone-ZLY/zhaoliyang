package com.zly.singletonPattern;

/**
 * @author zhaoliyang9
 * @des 懒汉式单例模式
 * @date 2023/8/11 16:53
 **/
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    public LazyInitializedSingleton(){}
    public LazyInitializedSingleton getInstance(){
        if(instance == null){
            return new LazyInitializedSingleton();
        }
        return instance;
    }
}
