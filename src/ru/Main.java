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
        System.out.println("1. Игра УГАДАЙКА. Числа от 0 до 9. 3 попытки. Возможность переиграть по выбору игрока.");
        System.out.println("2. Игра УГАДАЙ СЛОВО. Заданный массив слов, бесконечное количество попыток. Вывод угаданных букв.");
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
            taskNumber1();
        } else if (yourChoiсe == 2){
            taskNumber2();
        }else if(yourChoiсe == 0) return 0;
        return 1;
    }


    private static void taskNumber1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("'УГАДАЙКА'");
        System.out.println("Привет!");
        System.out.println("В игре 'УГАДАЙКА' тебе предстоит угадать число от 0 до 9, загаданное компьютером.");
        System.out.println("У тебя будет 3 попытки, израсходовав которые ты проиграешь и сможешь попробовать ещё раз.");

        while(true){
            if(guessGame());
            else break;
        }
    }

    private static void taskNumber2() {
        String gameName = "УГАДАЙ СЛОВО";
        System.out.printf("Привет! Это игра %s.%n", gameName);
        System.out.println("Я загадаю одно из этих слов:");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        for(int i = words.length-1; i > 0; i--){ //сортировка массива по длине слова
            for(int j = 0; j < i; j++){
                if(words[j].length() > words[j+1].length()){
                    String buff = words[j];
                    words[j] = words[j+1];
                    words[j+1] = buff;
                }
            }

        }
        for(int i = 0; i < words.length; i++){ //вывод массива на печать таблицей
            if(i%5 == 0) {
                System.out.println();
                System.out.printf("%10s", words[i]);
            }
            else System.out.printf("%10s", words[i]);
        }

        System.out.println();//отступы
        System.out.println();

        System.out.println("Попробуй угадать, какое слово я загадал.");
        System.out.println("Если ты не угадаешь, но в наших с тобой словах будут одинаковы буквы на одинаковых местах - я покажу их тебе с:");

        while (true) {
            if(guessWord(words));//запуск игры
            else break;

        }
    }


    private static boolean guessGame() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int number = (int)(Math.random() * 10);
        while (counter < 3){
            counter++;

            System.out.print("Угадай число: ");

            int playerTry = scanner.nextInt();

            if(playerTry == number){
                System.out.println("Вы победили!");
                break;
            }else if(playerTry > number){
                System.out.println("Загаданное число меньше.");
            }else if(playerTry < number){
                System.out.println("Загаданное число больше.");
            }
        }
        System.out.println("Повторить игру ещё раз? y/n");
        String repit = scanner.next();

        return (repit.equals("y"));
    }
    private static boolean guessWord(String[] words) {
        Scanner scanner = new Scanner(System.in);

        String answer = words[(int)(Math.random() * (words.length-1))]; //загадывается слово
        boolean exit = false; //условие выхода из метода
        final int SIZE = 15; //размер массива, заполненного #
        char[] answerArr = new char[SIZE]; //создание этого массива

        for(int i = 0; i < SIZE; i++){ //заполнение массива "#"
            answerArr[i] = 35;
        }

        while(!exit){

            System.out.print("Введите слово: ");
            String playerAnswer = scanner.next().toLowerCase(); //playerAnswer - введённое игроком слово

            exit = Compare(answer, playerAnswer, answerArr, SIZE); //запуск метода сравнения

        }

        return false;
    }

    private static boolean Compare(String answer, String playerAnswer, char[] answerArr, int SIZE) {
        if(playerAnswer.equals(answer)){ //если игрок угадал

            System.out.println("Мои поздравления! Вы угадали!");
            return true;

        }else if(playerAnswer.length() > answer.length()){ //решение проблемы, в которой при условии playerAnswer.length() < answer.length() выдавалась ошибка в цикле проверки

            System.out.print("Неправильно! Совпавшие буквы будут отображены здесь: ");

            for(int i = 0; i < answer.length(); i++){
                if(playerAnswer.charAt(i) == answer.charAt(i)) answerArr[i] = playerAnswer.charAt(i); //проверка совпадений букв в загаднном и введённых словах
            }

            for(int i = 0; i < SIZE; i++){
                System.out.print(answerArr[i]); //вывод в консоль массива с угаданными буквами и решётками (#)
            }

            System.out.println();
            return false;

        }else{

            System.out.print("Неправильно! Совпавшие буквы будут отображены здесь: ");

            for(int i = 0; i < playerAnswer.length(); i++){
                if(playerAnswer.charAt(i) == answer.charAt(i)) answerArr[i] = playerAnswer.charAt(i);
            }

            for(int i = 0; i < SIZE; i++){
                System.out.print(answerArr[i]);
            }

            System.out.println();
            return false;

        }
    }
}