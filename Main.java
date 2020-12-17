package ru;


import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static int addedFood; //переменная добавляемой еды
    public static String names[] = {"Топорик", "Корж", "Горгуля", "Альфред", "Гоблин"}; //массив имён котиков
    public static Cat[] cats = new Cat[names.length]; // массив с котиками
    public static Plate plate = new Plate(); // миска котиков


    public static void main(String[] args) {

        creatingCats(names.length); // создание котиков и заполнение ими массива

        menu(); // меню взаимодействия с котиками

    }

    // создание котов
    private static void creatingCats(int numbCats) {
        for(int i = 0; i < numbCats; i++){
            cats[i] = new Cat(names[i]);
        }
    }

    // МЕНЮ
    private static void menu() {
        int choise;
        while (true) {
            System.out.println("МЕНЮ ДЕЙСТВИЙ:");
            System.out.println("1. Вывести информацию о котиках.");
            System.out.println("2. Насыпать корм.");
            System.out.println("3. Позвать котиков кушать.");
            System.out.println("4. Начать новый день.");
            System.out.println("0. Выход.");
            System.out.print("Выберите действие: ");
            choise = scanner.nextInt();
            System.out.println();
            action(choise);
        }
    }

    // Выбор действия
    private static void action(int choise){
        if(choise == 1){
            catsInfo();
        }else if(choise == 2){
            addFood(plate);
        }else if(choise == 3){
            feedTheCats();
        }else if(choise == 4){
            newDay();
        }else if(choise == 0){
            System.out.println("Приходи ещё! Котики будут тебя ждать =(^-^)=");
            System.exit(0);
        }else{
            System.out.println("Это нельзя сделать! Возможно потом...\n");
        }
    }


    // Вывод информации обо всех котиках
    private static void catsInfo() {
        for (int i = 0; i < cats.length; i++) {
            cats[i].printInfo();
        }
    }

    // Насыпание корма в миску
    public static void addFood(Plate plate) {
        System.out.print("Насыпать корма: ");
        while(true) {
            addedFood = scanner.nextInt();
            if(addedFood > 0) {
                plate.addFood(addedFood);
                System.out.println();
                break;
            }else{
                System.out.println("Эта коробка корма пуста! Открывай новую :З");
            }
        }
    }

    // Кормление котиков
    private static void feedTheCats() {
        System.out.println("Котики, покушайте, пожалуйста!\n");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }

    // Начало нового дня
    private static void newDay() {
        System.out.println("Наступил новый день.\nКотики проголодались.\n");
        for (int i = 0; i < cats.length; i++) {
            cats[i].starve(); // вызов метода обнуляющих сытость котиков
        }
    }

}
