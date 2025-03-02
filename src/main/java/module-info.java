module org.example.clothesondemand {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.clothesondemand to javafx.fxml;
    exports org.example.clothesondemand;
    exports models;
    opens models to javafx.fxml;
}