package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //принимаем рут элемент sample.fxml для начала работы
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 400)); //создание новой сцены
        primaryStage.show(); //показать на экране


    }


    public static void main(String[] args) {
        launch(args);
    }



}
