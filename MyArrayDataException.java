package ru;

public class MyArrayDataException extends Exception{
    public MyArrayDataException() {
        super("Ошибка! В массиве должны быть только числа!");
    }

    public MyArrayDataException(int i, int j) {
        super("Ошибка! В ячейке х:" + (j+1) + " y:" + (i+1) + " лежит не число.");
    }
}
