package ru;

public class Wall implements Obstacles{

    private final int height;


    @Override
    public boolean start(Participants participant) { //запускаем метод бега конкретного участника с параметром входа - длина беговой дорожки
        if(participant.jump(height)){ // если перепрыгнул возвращаем true в метод theHungerGamesStart
            return true;
        }else {
            return false;
        }
    }

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " м.\n";
    }
}
