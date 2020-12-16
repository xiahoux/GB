package ru;

import java.util.Random;

public class Main {

    public Random random = new Random();

    public static void main(String[] args) {

        Dog dog = new Dog("Чёрный", "Уголёк", 2);
        Cat cat = new Cat("Красный", "Искорка", 2);

        System.out.println(cat);
        System.out.println(dog);

        dog.run(300);
        dog.jump(0.9);
        dog.swim(13);

        System.out.println();

        cat.run(210);
        cat.jump(1.9);
        cat.swim(3);

    }
}
