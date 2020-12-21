package sample;


import java.util.Random;
import java.util.Scanner;

public class GuessGameGraphics{

    private final int HIDDENNUMBER; //загаданное число
    public final int MAXHIDDENNUMBER; //максимальное число, которое может загадать компьютер
    private final Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public int tryCounter = 1; //номер попытки
    public final int MAXTRY = 5; //доступное количество попыток
    public String message; //информационное сообщение, выводящееся после каждой попытки



    public GuessGameGraphics(int maxHiddenNumber) {
        this.MAXHIDDENNUMBER = maxHiddenNumber;
        this.HIDDENNUMBER = random.nextInt(MAXHIDDENNUMBER) + 1;
    }

    public int getHIDDENNUMBER() {
        return HIDDENNUMBER;
    }

    public String getMessage() {
        return message;
    }

    public int getTryCounter() {
        return tryCounter;
    }

    public boolean playGame(int tryToGuess){

        if(tryToGuess < HIDDENNUMBER){ //сравнение числа игрока с загаданным числом
            message = "Загаданное число больше " + tryToGuess;
            tryCounter++;
            return false;
        } else if(tryToGuess > HIDDENNUMBER){
            message = "Загаданное число меньше " + tryToGuess;
            tryCounter++;
            return false;
        } else {
            message = "Молодец! Вы угадали!\n";
            return true;
        }

    }

}
