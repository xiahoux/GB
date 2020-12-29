package ru;

public class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Допускаются только массивы размерами 4х4! Повторите ввод!");
    }
}
