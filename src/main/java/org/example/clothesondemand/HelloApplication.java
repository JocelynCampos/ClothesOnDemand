package org.example.clothesondemand;

import controllers.TrafficController;
import enums.*;
import enums.Color;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import models.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private Label orderStatusLabel;
    private Order order;


    @Override
    public void start(Stage stage) throws IOException {
        Customer customer = new Customer("Jocelyn");
        List<Pants> pants = List.of(new Pants());
        List<TShirt> tShirts = List.of(new TShirt());
        List<Skirt> skirts = List.of(new Skirt());

        //Skapar tom order
        order = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        //Label för orderstatus
        orderStatusLabel = new Label("Order status: " + order.getOrderStatus());

        //Byxor
        Label pantsLabel = new Label("Create pants");

        //BYXOR : Storlek, Material, Färg, PassForm, Längd
        ComboBox<Size> pantsSizeComboBox = createSizeComboBox();
        ComboBox<Material> pantsMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> pantsColorComboBox = createColorComboBox();
        ComboBox<Fit> pantsFitComboBox = createFitComboBox();
        ComboBox<Length> pantsLengthComboBox = createLengthComboBox();

        Button addPantsButton = new Button("Add pants");
        addPantsButton.setOnAction(actionEvent -> {
            if (pantsSizeComboBox.getValue() != null && pantsMaterialComboBox != null &&
                    pantsColorComboBox != null && pantsFitComboBox != null && pantsLengthComboBox != null) {
                Pants pant = new Pants();
                order.getPantsList().add(pant);
            } else {
                System.out.println("Please fill all the boxes before adding pants into your shoppingbag.");
            }
        });

        //T-Shirt : Storlek, Material, Färg, Ärmar, Krage
        ComboBox<Size> tshirtSizeComboBox = createSizeComboBox();
        ComboBox<Material> tshirtMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> tshirtColorComboBox = createColorComboBox();
        ComboBox<Sleeves>  tshirtSleevesComboBox = createSleevesComboBox();
        ComboBox<Neck> tshirtNeckComboBox= createNeckComboBox();

        Button addTshirtButton = new Button("Add T-Shirt");
        addTshirtButton.setOnAction(actionEvent -> {

        });


        // Skirt : Storlek, Material, Färg, Midja, Mönster
        ComboBox<Size> skirtSizeComboBox = createSizeComboBox();
        ComboBox<Material> skirtMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> skirtColorComboBox = createColorComboBox();
        ComboBox<Waistline> waistlineComboBox = createWaistlineComboBox();
        ComboBox<Pattern> patternComboBox = createPatternComboBox();


        //Skapa new-order knapp
        Button addToOrderButton = new Button("Add to Order");
        addToOrderButton.setOnAction(actionEvent -> {
            order.placeOrder();
            orderStatusLabel.setText("Order status" + order.getOrderStatus());
        });

        //Spara beställning knapp
        Button completeOrderButton = new Button("Complete order");
        completeOrderButton.setOnAction(actionEvent -> {
            order.completedOrder();
            orderStatusLabel.setText("Order Status: " + order.getOrderStatus());
        });

        //Knappar
        HBox buttonBox = new HBox(10, addToOrderButton, completeOrderButton);

        VBox root = new VBox(20, orderStatusLabel, orderStatusLabel,buttonBox, pantsSizeComboBox, pantsMaterialComboBox, pantsColorComboBox);


        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Clothes on Demand");
        stage.setScene(scene);
        stage.show();


        }

    //ComboBoxes för de tre plaggens delade attribut
    public ComboBox<Size> createSizeComboBox() {
        ComboBox<Size> sizeComboBox = new ComboBox<>();
        sizeComboBox.getItems().addAll(Size.values());
        return sizeComboBox;
    }

    public ComboBox<Material> createMaterialComboBox() {
        ComboBox<Material> materialComboBox = new ComboBox<>();
        materialComboBox.getItems().addAll(Material.values());
        return materialComboBox;
    }

    public ComboBox<Color> createColorComboBox() {
        ComboBox<Color> colorComboBox = new ComboBox<>();
        colorComboBox.getItems().addAll(Color.values());
        return colorComboBox;
    }

    //Extra ComboBoxes för Pants
    public ComboBox<Fit> createFitComboBox() {
        ComboBox<Fit> fitComboBox = new ComboBox<>();
        fitComboBox.getItems().addAll(Fit.values());
        return fitComboBox;
    }

    public ComboBox<Length> createLengthComboBox() {
        ComboBox<Length> lengthComboBox = new ComboBox<>();
        lengthComboBox.getItems().addAll(Length.values());
        return lengthComboBox;
    }


    //Extra ComboBoxes för T-Shirt
    public ComboBox<Sleeves> createSleevesComboBox() {
        ComboBox<Sleeves> sleevesComboBox = new ComboBox<>();
        sleevesComboBox.getItems().addAll(Sleeves.values());
        return sleevesComboBox;
    }

    public ComboBox<Neck> createNeckComboBox() {
        ComboBox<Neck> neckComboBox = new ComboBox<>();
        neckComboBox.getItems().addAll(Neck.values());
        return neckComboBox;
    }

    //Extra ComboBoxes för Skirt
    public ComboBox<Waistline> createWaistlineComboBox() {
        ComboBox<Waistline> waistlineComboBox = new ComboBox<>();
        waistlineComboBox.getItems().addAll(Waistline.values());
        return waistlineComboBox;
    }

    public ComboBox<Pattern> createPatternComboBox() {
        ComboBox<Pattern> patternComboBox = new ComboBox<>();
        patternComboBox.getItems().addAll(Pattern.values());
        return patternComboBox;
    }





    public static void main(String[] args) {
        launch();
    }
}