package com.zly.upCastingAndDownCasting;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 18:05
 **/
public class UpCastingAndDownCastingTest {
    public static void main(String[] args) {
        // 向上转型upCasting
        Animal animal = new Bird();
        animal.eat();
        animal.breath();
        // 向下转型downCasting
        Bird bird = (Bird) animal;
        bird.eat();
        bird.fly();
    }
}
