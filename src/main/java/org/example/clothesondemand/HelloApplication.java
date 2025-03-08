package org.example.clothesondemand;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ClothingBuilder;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ClothingBuilder clothingBuilder = new ClothingBuilder();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}