package ru;

public class Robot implements Participants {

    private final int maxRunDistance;
    private final int maxJumpHeight;
    private final String name;


    public Robot(int maxRunDistance, int maxJumpHeight, String name) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.name = name;
    }

    @Override
    public boolean run(int distance) { //метод Бег возвращает true или false в Treadmill
        if(distance <= maxRunDistance){
            System.out.println("Робот " + name + " пробежал " + distance + " м.\n");
            return true;
        }else{
            System.out.println("Робот " + name + " не смог пробежать " + distance + " м.\n");
            return false;
        }
    }

    @Override
    public boolean jump(int height) { //метод Прыжок возвращает true или false в Treadmill
        if(height <= maxJumpHeight){
            System.out.println("Робот " + name + " перепрыгнул стену высотой " + height + " м.\n");
            return true;
        }else{
            System.out.println("Робот " + name + " не смог перепрыгнуть стену высотой " + height + " м.\n");
            return false;
        }
    }


    public String getName() {
        return name;
    }

    //Вывод информации
    void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Робот: " + name + ".\nМаксимальная дистанция бега: " + maxRunDistance + " м.\nМаксимальная высота прыжка: " + maxJumpHeight + " м.\n";
    }
}
