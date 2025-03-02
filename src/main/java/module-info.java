module org.example.clothesondemand {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.clothesondemand to javafx.fxml;
    exports org.example.clothesondemand;
    exports BussinessObjects;
    opens BussinessObjects to javafx.fxml;
}