package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public  class DynamicArray {
    static int max_size = 2;// текущий максимальный размер динамического массива
    static int size = 0; // Текущее количество элементов (пока 0)
    static int[] data = new int[max_size];// это массив целых чисел


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


    //отображает полное состояие динамического массива
    static void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }

    // Добавление элемента в массив
    static void add(int value) {
        // Если массив заполнен, увеличиваем его размер
        if (size >= max_size) {
            max_size *= 2;// Увеличиваем размер в два раза
            int[] temp = Arrays.copyOf(data, size); // Копируем данные во временный массив
            data = new int[max_size];// Создаем новый массив увеличенного размера
            //проходимся по всем эл массива temp, в кот хранятся копии эл старого массива
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];  // Копируем данные обратно
            }
        }
        data[size] = value; // Добавляем новый элемент
        //увеличиваем size на 1, чтобы при добавлении след эл он помещался в след ячейку массива
        size++;
    }

    //вспомогательный метод, проверяющий пуст массив или нет
    static boolean isEmpty() {
        return size == 0;
    }

    // Проверка, содержится ли элемент в массиве
    static boolean contains(int value) {
        //если индекс эл внутри массива существует, то массив этот эл содержит
        //если indexOf возвр -1, то эл нет, если возвр индекс, кот >= 0, то эл есть
        return indexOf(value) >= 0;
    }

    // Поиск индекса элемента по значению
    static int indexOf(int value) {
        //проходимся в цикле по эл массива, важно проходится до size т к в массиве data могут нах незаполненные эл
        for (int i = 0; i < size; i++) {
            //сравниваем значение, кот приходит в кач-ве параметра метода с тек значением в ячейке массива data
            //если data[i] = value, то это тот [i] что нам нужен, его и возвращаем
            if (data[i] == value) {
                return i;
            }
        }
        //если прошлись по всем эл массива и не нашли нужный эл, возвр -1
        return -1;
    }

    //получаем эл массива  data по индексу
    static int get(int index) {
        // Проверка, что индекс корректный
        if (index < 0 || index >= size) {
            //Выбрасывает исключение, если индекс некорректен.
            throw new RuntimeException("Index out of bound");
        }
        return data[index]; //Возвращает элемент по указанному индексу.
    }

    static void sort() {
        // Сортировка пузырьком
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Меняем элементы местами
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Удаление элемента по индексу
    static void remove(int index) {
        //Проверка на корректность индекса и не пуст ли массив
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bound");
        }
        // После удаления эл надо сдвинуть все элементы ПОСЛЕ удаленного на одну позицию влево
        //В цикле i = index, т к index - это позиция элемента, который нужно удалить
        //Цикл выполняется, пока i меньше size - 1 (последний элемент массива).
        for (int i = index; i < size - 1; i++) {
            //data[i] - это элемент массива на позиции i
            //data[i + 1] - это элемент массива на позиции i + 1 (следующий за i)
            // Значение элемента на позиции i + 1 присваивается элементу на позиции i
            // Таким образом, элемент "перемещается" на одну позицию влево
            data[i] = data[i + 1];
            //То есть на каждой итерации элемент data[i + 1] перемещается на позицию data[i]
            //Это продолжается до тех пор, пока все элементы правее удаленного не будут сдвинуты на одну позицию влево
        }
        size--; // Уменьшаем size после удаления элемента
    }
}



