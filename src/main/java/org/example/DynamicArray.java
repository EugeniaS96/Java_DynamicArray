package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public  class DynamicArray {
    static int max_size = 2;
    static int size = 0; 
    static int[] data = new int[max_size];


    public static void main(String[] args) {
        System.out.println(isEmpty());
        add(2);
        System.out.println(isEmpty());
        add(7);
        add(3);
        System.out.println(indexOf(2));
        System.out.println(contains(3));
        System.out.println(contains(4));
        add(5);
        add(6);
        remove(3);
        add(11);
        System.out.println(get(0));
        sort();
        print();
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }

    static void add(int value) {
        if (size >= max_size) {
            max_size *= 2;
            int[] temp = Arrays.copyOf(data, size); 
            data = new int[max_size];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;
    }

    static boolean isEmpty() {
        return size == 0;
    }

    static boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    static int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
    static int get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bound");
        }
        return data[index];
    }

    static void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
    static void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bound");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--; 
    }
}



