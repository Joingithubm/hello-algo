package com.zeng.stack.array;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Author: fanchao
 * Date: 2024/9/25 11:49
 * Version: v1.0.0
 * Description:
 **/
public class ArrayStack {

    private int[] array;
    private int size = 0;
    private int capacity;
    private int top;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        array[++top] = value;
        size++;
    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(Arrays.toString(stack.array));

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(Arrays.toString(stack.array));
    }
}
