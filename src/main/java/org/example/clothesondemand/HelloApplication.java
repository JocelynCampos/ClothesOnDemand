package org.example.clothesondemand;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    @Override
    public void start(Stage stage) throws IOException {


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}