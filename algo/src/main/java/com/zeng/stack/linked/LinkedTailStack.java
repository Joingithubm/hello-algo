package com.zeng.stack.linked;

import java.util.EmptyStackException;

/**
 * Author: fanchao
 * Date: 2024/9/25 9:48
 * Version: v1.0.0
 * Description:
 **/
public class LinkedTailStack {

    private int size;
    private TailNode tail;

    public void push(int val){
        if (tail == null){
            tail = new TailNode(val);
        }else {
            tail = new TailNode(val, tail);
        }
        size ++;
    }

    public int pop(){
        if (tail == null){
            throw new EmptyStackException();
        }

        TailNode pre = tail.getPre();
        tail.setPre(null);
        int val = tail.getVal();
        tail = pre;
        size --;
        return val;
    }

    public int peek(){
        if (tail == null){
            throw new EmptyStackException();
        }
        return tail.getVal();
    }

    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        LinkedTailStack stack = new LinkedTailStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
    }

}

class TailNode{

    private int val;
    private TailNode pre;

    public TailNode(int val){
        this.val = val;
    }
    public TailNode(int val, TailNode pre){
        this.val = val;
        this.pre = pre;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TailNode getPre() {
        return pre;
    }

    public void setPre(TailNode pre) {
        this.pre = pre;
    }
}