package ru;

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
        System.out.println("3. Метод вычисления выражения a * (b + (c / d))");
        System.out.println("4. Метод, проверяющий, попадает ли сумма двух чисел, данных на вход, в диапазон 10-20.");
        System.out.println("5. Метод, проверяющий знак числа и печатающий результат в консоль.");
        System.out.println("6. Метод, возвращающий true, если введённое число отрицательное.");
        System.out.println("7. Метод, принимающий строку с именем и печатающий в консоль приветствие.");
        System.out.println("*8. Метод, определяющий, является ли год високосным.");
        System.out.println("0. Выход.");


        while (true) { //цикл для выбора задания
            System.out.println("Введи номер задания:");
            yourChoiсe = scanner.nextInt();
            exit = dataInput(yourChoiсe);
            if(exit == 0) break;
        }
        System.out.println("Спасибо за проверку! До свидания!");

    }

    private static int dataInput(int yourChoiсe) { //метод, запрашивающий ввод данных под определённое задание

        Scanner scanner = new Scanner(System.in);

        if(yourChoiсe == 3){ //ввод данных для задания №3

            System.out.println("Введите а:");
            double a = scanner.nextDouble();
            System.out.println("Введите b:");
            double b = scanner.nextDouble();
            System.out.println("Введите с:");
            double c = scanner.nextDouble();
            System.out.println("Введите d:");
            double d = scanner.nextDouble();

            double result = homeWork3(a, b, c, d); //вызов метода задания №3
            System.out.println("Результат выражения равен: " + result);

        }else if(yourChoiсe == 4){ //ввод данных для задания №4

            System.out.println("Введите а:");
            int a = scanner.nextInt();
            System.out.println("Введите b:");
            int b = scanner.nextInt();

            boolean result = homeWork4(a, b); //вызов метода задания №4
            if(result) System.out.println("Сумма в диапазоне.");
            else System.out.println("Сумма вне диапазона.");

        }else if(yourChoiсe == 5){ //ввод данных для задания №5

            System.out.println("Введите число:");
            int a = scanner.nextInt();

            homeWork5(a); //вызов метода задания №5


        }else if(yourChoiсe == 6){ //ввод данных для задания №6

            System.out.println("Введите число:");
            int a = scanner.nextInt();

            boolean result = homeWork6(a); //вызов метода задания №6
            if(result) System.out.println("Число отрицательное.");
            else System.out.println("Число положительное.");

        }else if(yourChoiсe == 7){ //ввод данных для задания №7

            System.out.println("Введите Имя:");
            String name = scanner.next();

            homeWork7(name); //вызов метода задания №7

        }else if(yourChoiсe == 8){ //ввод данных для задания №*8

            System.out.println("Введите год:");
            int year = scanner.nextInt();

            homeWork8(year);
        }else if(yourChoiсe == 0) return 0;
        return 1;
    }



    private static double homeWork3(double a, double b, double c, double d) { //метод задания №3
        return a * (b + (c / d));
    }

    private static boolean homeWork4(int a, int b) { //метод задания №4
        return a + b >=10 && a + b <= 20;
    }

    private static void homeWork5(int a) { //метода задания №5
        if(a < 0) System.out.println("Число отрицательное.");
        else System.out.println("Число положительное.");
    }

    private static boolean homeWork6(int a) { //метод задания №6
        return a < 0;
    }

    private static void homeWork7(String name) { //метод задания №7
        System.out.println("Привет, " + name + "!");
    }

    private static void homeWork8(int year) { //метод задания №8
        if(year % 4 == 0 && (year % 100 != 0 ^ year % 400 == 0)) System.out.println("Год високосный.");
        else System.out.println("Год невисокосный.");
    }
}