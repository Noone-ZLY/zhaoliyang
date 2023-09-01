package com.zly.stack;

import java.util.Stack;

/**
 * @author zhaoliyang9
 * @des 两个栈模拟队列
 * @date 2023/8/30 17:14
 **/
public class CQueue {
    Stack s1 = null;
    Stack s2 = null;
    public CQueue() {
        this.s1 = new Stack();
        this.s2 = new Stack();
    }
    public void appendTail(int value) {
        this.s2.add(value);
    }

    public int deleteHead() {
        if (this.s1.isEmpty() && !this.s2.isEmpty()){
            while(!this.s2.isEmpty()){
                this.s1.add(this.s2.pop());
            }
        }
        if (!this.s1.isEmpty()){
            return (int) this.s1.pop();
        }
        return -1;
    }
}
class CQueueTest{
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }
}
