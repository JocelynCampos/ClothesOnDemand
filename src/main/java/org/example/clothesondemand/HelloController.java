package org.example.clothesondemand;
;
import javafx.scene.control.Label;

public class HelloController {
    private Label welcomeText;

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}