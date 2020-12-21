package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;



public class Controller {

    GuessGameGraphics game;


    @FXML
    private Button startButton;
    @FXML
    private TextField textField;
    @FXML
    private Label titleHeader;
    @FXML
    private Label infoField;
    @FXML
    private Button restartButton;
    @FXML
    private Button tryButton;
    @FXML
    private Button startButton1;
    @FXML
    private Label tryCounterField;
    @FXML

    void doAction() {
        if(startButton1.isVisible()){ //Если вводится максимальное число, которое компьютер может загадать
            startGameParameters();//создаём новое игровое поле
        } else {
            try {
                if(game.playGame(Integer.parseInt(textField.getText()))) { //если игрок угадал число
                    infoField.setText(game.getMessage());//вывод сообщения о победе
                    tryCounterField.setText("ПОПЫТКА: " + game.getTryCounter());
                    victory();//запуск метода победы

                }else{ //если игрок не угадал
                    infoField.setText(game.getMessage());//вывод информации
                    textField.setText("");//очищение поля ввода текста
                    if(game.getTryCounter() == game.MAXTRY + 1){//проверка наличия оставшихся попыток
                        gameOver();//если попытки кончились, вызвать метод окончания игры
                    }
                    tryCounterField.setText("ПОПЫТКА: " + game.getTryCounter());

                }
            } catch (NumberFormatException e) {
                infoField.setText("Ошибка! Введите число.");
            }
        }

    }

    @FXML
    void startGame() { //отрисовываем начальное состояние после нажатия "Начать"
        restartButton.setVisible(false);
        startButton.setVisible(false);
        titleHeader.setVisible(false);
        startButton1.setVisible(true); //кнопка ввода максимального числа, которое компьютер может загадать
        textField.setVisible(true);//отрисовка поля ввода текста
        infoField.setVisible(true);//отрисовка информационной панели

        infoField.setText("Введите максимальное число, которое\nя могу загадать");
    }
    @FXML
    void startGameParameters() { //создаём новое игровое поле

        try {
            game = new GuessGameGraphics(Integer.parseInt(textField.getText())); //передаём экземпляру игры параметр максимального числа, которое она может загадать
            textField.setText("");//очищаем поле ввода
            startButton1.setVisible(false);//убираем кнопку ввода максимального числа
            tryButton.setVisible(true);//рисуем кнопку "Попробовать угадать"
            infoField.setText("Угадайте число от 1 до " + game.MAXHIDDENNUMBER);
            tryCounterField.setVisible(true);//рисуем отображение номера текущей попытки
            tryCounterField.setText("ПОПЫТКА: " + String.valueOf(game.getTryCounter()));
        } catch (NumberFormatException e){
            infoField.setText("Ошибка! Я просил число >_<");
        }

    }
    @FXML
    void gameOver(){ //конец игры, очистка поля, вывод информации
        textField.setText("");
        textField.setVisible(false);
        infoField.setText("Вы проиграли!\nЯ загадал: " + game.getHIDDENNUMBER());
        tryButton.setVisible(false);
        restartButton.setVisible(true); //рисуем кнопку повтора игры
        tryCounterField.setText("");
        tryCounterField.setVisible(false);
    }

    @FXML
    void victory(){ //победа, очистка поля, вывод информации
        textField.setText("");
        textField.setVisible(false);
        infoField.setText(game.getMessage() + "\nЯ загадал: " + game.getHIDDENNUMBER());
        tryButton.setVisible(false);
        restartButton.setVisible(true); //рисуем кнопку повтора игры
        tryCounterField.setText("");
        tryCounterField.setVisible(false);
    }

}
