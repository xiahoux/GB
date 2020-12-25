package ru;

public class Cat implements Participants{

    private final int maxRunDistance;
    private final int maxJumpHeight;
    private final String name;


    public Cat(int maxRunDistance, int maxJumpHeight, String name) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.name = name;
    }

    @Override
    public boolean run(int distance) { //метод Бег возвращает true или false в Treadmill
        if(distance <= maxRunDistance){
            System.out.println("Кот " + name + " пробежал " + distance + " м.\n");
            return true;
        }else{
            System.out.println("Кот " + name + " не смог пробежать " + distance + " м.\n");
            return false;
        }
    }

    @Override
    public boolean jump(int height) { //метод Прыжок возвращает true или false в Treadmill
        if(height <= maxJumpHeight){
            System.out.println("Кот " + name + " перепрыгнул стену высотой " + height + " м.\n");
            return true;
        }else{
            System.out.println("Кот " + name + " не смог перепрыгнуть стену высотой " + height + " м.\n");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void printInfo(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Кот: " + name + ".\nМаксимальная дистанция бега: " + maxRunDistance + " м.\nМаксимальная высота прыжка: " + maxJumpHeight + " м.\n";
    }
}
