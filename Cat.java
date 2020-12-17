package ru;

public class Cat {

    private String name;
    private int appetite; // Аппетит котика, у каждого свой, но он не меняется
    private boolean satiety; // Сытость котика. Если он голоден, то хочет съесть количество еды соразмерно своему аппетиту
    private final String hungry = "Голоден.";
    private final String full = "Сыт.";
    private String strSatiety = hungry;


    // Конструктор котика
    public Cat(String name) {
        this.name = name;
        this.appetite = (int)(Math.random() * 4) + 3; //аппетит
        this.satiety = false;
    }

    // Реализация попытки кота поесть
    public void eat(Plate plate){

        if(satiety){ // Если он сыт

            System.out.println(name + " сыт.");
            System.out.println();

        }else if(plate.getFood() == 0){ // Если миска пуста

            System.out.println(name + ": Миска пустая!! Кокое плохое зло я тебе зделал? =(>_<)=\n");
            strSatiety = hungry;

        }else if(appetite > plate.getFood()) { // Если в миске недостаточно еды для насыщения котика

            System.out.println(name + " не наестся таким количеством корма. Он не станет есть.");
            plate.printInfo();
            strSatiety = hungry;

        }
        else{ // Если еды достаточно

            System.out.println(name + " поел и насытился.");
            plate.decreaseFood(appetite);
            plate.printInfo();
            satiety = true;
            strSatiety = full;

        }
    }

    // Обнуление сытости котика к началу нового дня
    public void starve(){
        satiety = false;
        strSatiety = hungry;
    }

    @Override
    public String toString() {
        return "Кот - " + name + ".\nАппетит: " + appetite + ".\nСытость: " + strSatiety + "\n";
    }

    public void printInfo() {
        System.out.println(this);
    }
}
