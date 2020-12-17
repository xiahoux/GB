package ru;

public class Plate {

    private int food;


    public int getFood() {
        return food;
    }

    // Добавление еды
    public void addFood(int food) {
        this.food += food;
    }

    // Уменьшение еды
    public void decreaseFood(int food){
        this.food -= food;
    }


    public void printInfo(){
        System.out.println("В миске: " + food + " ед. корма.\n");
    }


}
