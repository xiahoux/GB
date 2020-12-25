package ru;

public class Treadmill implements Obstacles{


    private final int distance;


    @Override
    public boolean start(Participants participant) { //запускаем метод бега конкретного участника с параметром входа - длина беговой дорожки
        if(participant.run(distance)){ //если пробежал возвращаем true в метод theHungerGamesStart
            return true;
        }else{
            return false;
        }
    }

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Беговой участок длиной " + distance + " м.\n";
    }
}
