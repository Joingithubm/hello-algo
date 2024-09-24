package com.zeng.arraylinkedlist.list;

import java.util.Arrays;

/**
 * @Author: fanchao
 * @Date: 2024-09-24 22:54
 * @Description:
 **/
public class MyList {

    private int[] array;
    private int size;
    private int capacity = 2;
    private int extendRatio = 2;

    public MyList(){
        array = new int[capacity];
    }

    public int size(){
        return this.size;
    }

    public int capacity(){
        return this.capacity;
    }

    public void add(int val){

        if (size == capacity) {
            expansion();
        }
        if (size < capacity){
            array[size] = val;
            size ++;
            return;
        }
    }

    public void add(int idx, int val){
        if (size == capacity){
            expansion();
        }
        if (idx > capacity){
            throw new RuntimeException("over array index");
        }

        System.arraycopy(array, idx, array, idx + 1, size - idx);
        array[idx] = val;
    }

    public int get(int idx){
        if (idx > capacity){
            throw new RuntimeException("over array index");
        }
        return array[idx];
    }

    private void expansion(){
        int newCapacity = capacity * extendRatio;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = newCapacity;
        array = newArray;
    }

    public static void main(String[] args) {

        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList.size);
        System.out.println(myList.capacity);
        System.out.println(Arrays.toString(myList.array));

        myList.add(1, 0);
        System.out.println(Arrays.toString(myList.array));
    }
}
