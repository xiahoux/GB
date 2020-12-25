package ru;

import java.util.Random;

public class Main {

    public static final int QUANTITI = 6; //число участников
    public static final int NUMBEROBSTACLES = 7; //число препятствий
    public static final String[] names = {"Destroyer", "Ломтик", "Роршах", "Хаттори Ханзо", "Глазурь", "Канат"}; //массив имён
    public static Participants participants[] = new Participants[QUANTITI]; //инициализация массива участников
    public static Obstacles obstacles[] = new Obstacles[NUMBEROBSTACLES]; //инициализация массива препятствий
    public static Random random = new Random();



    public static void main(String[] args) {

        createParticipants(QUANTITI); //создание участников
        createObstacles(NUMBEROBSTACLES); //создание препятствий
        theHungerGamesStart(); //начало забега


    }



    // Создание участников
    private static void createParticipants(int quantiti) {
        for (int i = 0; i < quantiti; i++) {
            if((i % 3) == 0){
                participants[i] = new Robot(random.nextInt(200) + 50, random.nextInt(4) + 1, names[i]);
            }else if((i % 2) == 0){
                participants[i] = new Cat(random.nextInt(200) + 50, random.nextInt(4) + 1, names[i]);
            }else{
                participants[i] = new Human(random.nextInt(200) + 50, random.nextInt(4) + 1, names[i]);
            }
        }
    }

    // Создание препятствий
    private static void createObstacles(int numberobstacles) {
        for (int i = 0; i < numberobstacles; i++) {
            if((i % 2) == 0){
                obstacles[i] = new Treadmill(random.nextInt(190) + 10);
            }else{
                obstacles[i] = new Wall(random.nextInt(3) + 1);
            }
        }
    }

    // Начало забега
    private static void theHungerGamesStart() {
        for (int i = 0; i < QUANTITI; i++) { //прохождение по участникам
            for (int j = 0; j < NUMBEROBSTACLES; j++) { //прохождение по препятствиям
                if(!obstacles[j].start(participants[i])){ //если участник не смог пробежать
                    j = NUMBEROBSTACLES+1; //используем условие выхода из цикла прохождения препятствий
                    System.out.println(participants[i].toString() + " Выбыл из забега!\n"); //выводим сообщение о проигрыше
                }else if(j == NUMBEROBSTACLES -1){ //если участник прошёл препятствие, проверить, не последнее ли это было препятствие
                    System.out.println(participants[i].toString() + " Добежал до конца! Поздравляем!\n"); //если да - вывод сообщения о победе
                }
            }

        }
    }

}
