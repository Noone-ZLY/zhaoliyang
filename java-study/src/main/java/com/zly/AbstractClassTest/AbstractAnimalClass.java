package com.zly.AbstractClassTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/28 17:55
 **/
public abstract class AbstractAnimalClass {
    /*
    * 1、可以有普通成员变量以及静态成员变量
    * 2、可以有构造函数
    * 3、子类不可以多继承抽象类
    * 4、抽象类不存在没有抽象方法，可以有静态方法，也可以普通方法
    * 5、可以存在普通方法
    * */
    String name = null;
    private static int age = 0;
    private static final int height = 0;

    public AbstractAnimalClass(String name, int age){
        this.name = name;
        this.age = age;
    }

    static void talk(){
        System.out.println("Animal can talk.");
    }

    public abstract void walk();

    protected abstract void eat();
}
