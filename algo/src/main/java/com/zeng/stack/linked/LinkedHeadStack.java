package com.zeng.stack.linked;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Author: fanchao
 * Date: 2024/9/25 9:32
 * Version: v1.0.0
 * Description:
 **/
public class LinkedHeadStack {

    private Node head;
    private int size;

    public void push(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Node next = head.getNext();
        int val = head.getVal();
        head.setNext(null);
        head = next;
        size --;
        return val;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.getVal();
    }

    public int getSize(){
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node tmp = head;
        for (int i = 0; i < size ; i++) {
            arr[i] = tmp.getVal();
            tmp = tmp.getNext();
        }
        return arr;
    }

    public static void main(String[] args) {
        LinkedHeadStack stack = new LinkedHeadStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(Arrays.toString(stack.toArray()));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);
        stack.push(5);
        System.out.println(Arrays.toString(stack.toArray()));
    }
}


class Node{
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setVal(int val){
        this.val = val;
    }

    public Node getNext(){
        return this.next;
    }

    public int getVal(){
        return this.val;
    }
}
