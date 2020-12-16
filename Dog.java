package ru;

public class Dog extends Animal {

    protected static int maxRunDistance = (int) ((Math.random() * 300) + 300);
    protected static double maxJumpHeight = (Math.random() * 1.2) + 0.3;
    protected static int maxSwimDistance = (int) ((Math.random() * 20) + 5);
    protected static String maxJumpHeightRound = String.format("%.1f", maxJumpHeight);

    public Dog(String color, String name, int age) {
        super(color, name, age, maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public String toString() {
        return "Собака " +
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
            System.out.println("Пёс " + name + " пробежал " + runDistance + " м.");
        } else if(runDistance < 0) {
            System.out.println("Наши не отступают!");
        }else{
            System.out.println("Собаки столько не бегают. Может натренировать её?");
        }
    }

    @Override
    public void jump(double jumpHeigh) {
        if(jumpHeigh <= maxJumpHeight && jumpHeigh >= 0){
            System.out.println("Пёс " + name + " перепрыгнул препятствие высотой " + jumpHeigh + " м.");
        }else if(jumpHeigh < 0){
            System.out.println("Ты хочешь, чтобы " + name + " сделал подкоп?");
        }else{
            System.out.println(name + " не может перепрыгнуть это препятствие. Оно слишком высокое.");
        }
    }

    @Override
    public void swim(int swimDistance) {
        if(swimDistance <= maxSwimDistance && swimDistance >= 0){
            System.out.println("Пёс " + name + " проплыл " + swimDistance + " м.");
        }else if(swimDistance < 0){
            System.out.println("Назад не поплыву! Гаф!");
        }else{
            System.out.println("Собака не может проплыть так много.");
        }
    }
}
