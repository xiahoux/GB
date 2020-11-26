package ru;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int yourChoiсe; //переменная для выбора задания
        int exit = 1;
        System.out.println("Привет! Здесь представлен список выполненных заданий.");
        System.out.println("Введи номер задания, чтобы запустить соответствующий метод.");
        System.out.println("Выбор задания зациклен, так что можно запускать один и тот же метод сколько угодно раз подряд");
        System.out.println("без перезапуска программы.");
        System.out.println("Меню заданий:");
        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;");
        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
        System.out.println("5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)");
        System.out.println("6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны;");
        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами;");
        System.out.println("0. Выход.");


        while (true) { //цикл для выбора задания
            System.out.print("Введи номер задания:");
            yourChoiсe = scanner.nextInt();
            exit = dataInput(yourChoiсe);
            if(exit == 0) break;
        }
        System.out.println("Спасибо за проверку! До свидания!");

    }

    private static int dataInput(int yourChoiсe) { //метод, запрашивающий ввод данных под определённое задание

        Scanner scanner = new Scanner(System.in);

        if (yourChoiсe == 1) {
            int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 0, 1};
            System.out.println("Изначальный массив: " + Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) arr[i] = 0;
                else arr[i] = 1;
            }
            System.out.println("Получившийся массив: " + Arrays.toString(arr));

        } else if(yourChoiсe == 2){
            final int SIZE = 8;
            int[] arr = new int[SIZE];
            for(int i = 0; i < SIZE; i++){
                if(i > 0) arr[i] = arr[i-1] + 3;
                else arr[i] = i;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else if(yourChoiсe == 3){
            int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < 6) arr[i] = arr[i] * 2;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }else if(yourChoiсe == 4){
            final int SIZE = 10;
            int[][] arr = new int[SIZE][SIZE];
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    if(j == i || j + i == SIZE - 1) arr[i][j] = 1;
                    else arr[i][j] = 0;
                    System.out.printf("%2d ", arr[i][j]);
                }
                System.out.println();
            }
        }else if(yourChoiсe == 5){
            final int SIZE = 20;
            int[] arr = new int[SIZE];
            int min = 100;
            int max = 0;
            for(int i = 0; i < SIZE; i++){
                arr[i] = (int)(Math.random() * 100);
                System.out.print(arr[i] + " ");
                if(arr[i] < min) min = arr[i];
                if(arr[i] > max) max = arr[i];
            }
            System.out.println();
            System.out.println("Максимум равен: " + max);
            System.out.println("Минимум равен: " + min);
        }else if(yourChoiсe == 6){
            final int SIZE = 5;
            int[] arr = new int[SIZE];
            for(int i = 0; i < SIZE; i++){
                arr[i] = (int)(Math.random() * 10);
                System.out.print(arr[i] + " ");
            }
            boolean result = checkBalance(arr);
            if(result) System.out.println("Баланс найден!");
            else System.out.println("Баланс не найден.");
        }else if(yourChoiсe == 7){
            final int SIZE = 10;
            int[] arr = new int[SIZE];
            for(int i = 0; i < arr.length; i++){
                arr[i] = (int)(Math.random() * 10);
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.print("Введите n: ");
            int n = scanner.nextInt();
            System.out.println(Arrays.toString(arr) + " - исходный массив");
            arr = shift(arr, n);
            System.out.println(Arrays.toString(arr) + " - массив после сдвига");

        }else if(yourChoiсe == 0) return 0;
        return 1;

    }
    private static boolean checkBalance(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < arr.length-1; i++){
            sum1 += arr[i];
            for(int j = i+1; j < arr.length; j++){
                sum2 += arr[j];
            }
            if(sum1 == sum2) break;
            sum2 = 0;
        }
        return sum1 == sum2;
    }
    private static int[] shift(int[] arr, int n) {
        if(n > 0){
            for(int i = 1; i <= n; i++) {
                int arrDrop = arr[arr.length-1];
                for (int j = arr.length-1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = arrDrop;
            }
        }else if(n < 0){
            for(int i = -1; i >= n; i--){
                int arrDrop = arr[0];
                for (int j = 0; j < arr.length-1; j++){
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = arrDrop;
            }
        }else System.out.println("На ноль сдвигать нельзя :ъ");
        return arr;
    }
}