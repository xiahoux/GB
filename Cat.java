package ru;

import java.util.Random;

public class Cat extends Animal {

    protected static int maxRunDistance = (int) ((Math.random() * 200) + 100);
    protected static double maxJumpHeight = (Math.random() * 2.0) + 0.5;
    protected static String maxJumpHeightRound = String.format("%.1f", maxJumpHeight);

    public Cat(String color, String name, int age) {
        super(color, name, age, maxRunDistance, maxJumpHeight);
    }


    @Override
    public String toString() {
        return "Кот " +
                "\nЦвет: " + color +
                "\nИмя: " + name +
                "\nВозраст: " + age +
                "\nМаксимальная дистанция бега: " + maxRunDistance + " м" +
                "\nМаксимальная высота прыжка: " + maxJumpHeightRound + " м" +
                "\nМаксимальная дистанция заплыва: " + maxSwimDistance + " м.\n";
    }

    @Override
    public void run(int runDistance) {
        if(runDistance <= maxRunDistance && runDistance >= 0){
            System.out.println("Кот " + name + " пробежал " + runDistance + " м.");
        }else if(runDistance < 0){
            System.out.println(name + " не побежит назад.");
        }else{
            System.out.println("Котики не могут столько пробежать. Им лень.");
        }

    }

    @Override
    public void jump(double jumpHeight) {
        if(jumpHeight <= maxJumpHeight && jumpHeight >= 0){
            System.out.println(name + " перепрыгнул препятствие высотой " + jumpHeight + " м.");
        }else if(jumpHeight < 0){
            System.out.println("Кот не станет этого делать.");
        }else{
            System.out.println("Коты, конечно, прыгучие, но не настолько. Нужно препятствие пониже.");
        }

    }

    @Override
    public void swim(int swimDistance) {
        System.out.println("Ну да, попробуй заставить кота поплавать.");
    }
}





