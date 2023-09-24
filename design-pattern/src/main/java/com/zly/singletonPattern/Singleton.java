package com.zly.singletonPattern;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/16 17:20
 * @description : 双重校验锁创建单例模式
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){}
    public static Singleton getSingleton(){
        // 判断单例是否被实例化，如果没有则类对象加锁
        if(instance == null){
            synchronized (Singleton.class){
                return new Singleton();
            }
        }
        return instance;
    }
}
