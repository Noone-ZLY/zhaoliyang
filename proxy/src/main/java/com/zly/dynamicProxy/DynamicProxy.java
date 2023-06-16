package com.zly.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/6/6 18:37
 **/
public class DynamicProxy implements InvocationHandler {

    private Object animal;

    public Object getAnimal() {
        return animal;
    }

    public void setAnimal(Object animal) {
        this.animal = animal;
    }
    public DynamicProxy(){

    }
    public DynamicProxy(Object animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        frontService();
        Object invokeObject = method.invoke(animal, args);
        endService();
        return null;
    }

    public void frontService(){
        System.out.println("张嘴了");
    }

    public void endService(){
        System.out.println("闭嘴了");
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), this);
    }
}
