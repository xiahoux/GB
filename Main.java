package ru;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String [] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10", "х"};
    public static String[][] arr;
    public static int size1 = 0;
    public static int size2 = 0;
    public static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            System.out.println("Привет! Надо создать массив 4х4.\nПожалуйста, введи эти размеры в консоль с:");
            int sumArr;

            while(true){
                if(arrayDataInput(size1, size2)){
                    break;
                }
            }
            scanner.close();
            sumArr = summer(arr);

            System.out.println("Сумма всех элементов массива равна: " + sumArr);
        }

    private  static boolean arrayDataInput(int size1, int size2){ //Ввод размеров и вызов метода заполнения массива
        try {
            size1 = scanner.nextInt();
            size2 = scanner.nextInt();
            arr = new String[size1][size2];

            createArray(size1, size2, arr);

            if(arr.length != 4 || arr[0].length != 4) {
                throw new MyArraySizeException();
            }

            return true;
        }catch (MyArraySizeException e){
            e.printStackTrace();
            return false;
        }

    }

    private static void createArray(int size1, int size2, String[][] arr) { //Заполнение массива
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                arr[i][j] = numbers[(int) (Math.random() * numbers.length)];
                System.out.printf("%2s, ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int summer(String[][] arr) { //метод ДЗ

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try{
                    for (char c : arr[i][j].toCharArray()) {
                        if(c < 48 || c > 57){ //диапазон кодировок символов UTF-16 от 0 до 9
                            throw new MyArrayDataException(i, j);
                        }
                    }
                    sum += Integer.parseInt(arr[i][j]);
                }catch (MyArrayDataException e){
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }
}
