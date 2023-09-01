package com.zly.interfaceTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 18:19
 **/
public interface Animal {
    /*
    * 1、接口可以有静态成员变量，不能存在普通成员变量
    * 2、接口不存在构造函数
    * 3、接口可以没有方法，可以有静态方法、可以有默认实现的方法
    * 4、一个类可以同时实现多个接口
    * */
    static String name = null;
    static void talk(){
        System.out.println("Animal can talk.");
    }
    default void eat(){
        System.out.println("Animal can eat");
    }

    void walk();
}
