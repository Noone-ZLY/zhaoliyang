package com.zly.Reflect;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/24 17:18
 **/
class B{
    public void talk(){}
}

class C extends B{
    @Override
    public void talk() {}

//    public void eat(){}
}
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Queue<Integer> queue = new ArrayDeque();
        queue.add(1);
        queue.offer(0);
        queue.forEach(num ->{
            System.out.println(num);
        });
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
//        queue.remove();
    }
    public static void print(Integer ...nums){
        for(Integer num : nums){
            System.out.print(num + ", ");
        }
    }
}
