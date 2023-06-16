package com.zly.staticProxy;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:11
 **/
public class StaticProxy implements Animal{
    private Dog dog;

    public StaticProxy(Dog dog){
        this.dog = dog;
    }

    public void setDog(Dog dog){
        this.dog = dog;
    }

    public Dog getDog(){
        return this.dog;
    }

    @Override
    public void talk(String msg) {
        frontService();
        this.dog.talk(msg);
        endService();
    }

    public void frontService(){
        System.out.println("张嘴了");
    }

    public void endService(){
        System.out.println("闭嘴了");
    }
}
