package com.zeng.queue.array;

import java.util.Arrays;

/**
 * Author: fanchao
 * Date: 2024/9/25 12:47
 * Version: v1.0.0
 * Description:
 **/
public class ArrayQueue {

    private int[] array;
    private int front = 0;
    private int size = 0;
    private int capacity;
    private int rear = 1;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void push(int value) {
        array[rear++] = value;
        size++;
    }

    public int pop() {
        return array[front++];
    }

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        queue.push(1);
        queue.push(2);

        System.out.println(Arrays.toString(queue.array));
        System.out.println(queue.pop());

        queue.push(3);


    }
}
