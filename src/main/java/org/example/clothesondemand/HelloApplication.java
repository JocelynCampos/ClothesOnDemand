package org.example.clothesondemand;

import controllers.TrafficController;
import enums.*;
import enums.Color;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.*;
import javafx.scene.Scene;
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
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Label orderStatusLabel;
    private Order order;


    @Override
    public void start(Stage stage) throws IOException {
        Customer customer = new Customer("Jocelyn");
        List<Pants> pants = List.of(new Pants());
        List<TShirt> tShirts = List.of(new TShirt());
        List<Skirt> skirts = List.of(new Skirt());

        TabPane tabPane = new TabPane();
        Tab pantsTab = new Tab("Pants");
        Tab tShirtTab = new Tab("T-Shirt");
        Tab skirtTab = new Tab("Skirt");
        Tab summaryTab = new Tab("Order Summary");

        tabPane.getTabs().addAll(pantsTab, tShirtTab, skirtTab, summaryTab);

        //Skapar tom order
        order = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        //Label för orderstatus
        orderStatusLabel = new Label("Order status: " + order.getOrderStatus());

        //Byxor
        Label pantsLabel = new Label("Create pants");

        //BYXOR : Storlek, Material, Färg, PassForm, Längd
        ComboBox<Size> pantsSizeComboBox = createSizeComboBox();
        pantsSizeComboBox.setVisible(false);

        ComboBox<Material> pantsMaterialComboBox = createMaterialComboBox();
        pantsMaterialComboBox.setVisible(false);

        ComboBox<Color> pantsColorComboBox = createColorComboBox();
        pantsColorComboBox.setVisible(false);

        ComboBox<Fit> pantsFitComboBox = createFitComboBox();
        pantsFitComboBox.setVisible(false);

        ComboBox<Length> pantsLengthComboBox = createLengthComboBox();
        pantsLengthComboBox.setVisible(false);

        Button addPantsButton = new Button("Add pants");
        addPantsButton.setOnAction(actionEvent -> {
            pantsSizeComboBox.setVisible(true);
            pantsMaterialComboBox.setVisible(true);
            pantsColorComboBox.setVisible(true);
            pantsFitComboBox.setVisible(true);
            pantsLengthComboBox.setVisible(true);

            if (pantsSizeComboBox.getValue() != null && pantsMaterialComboBox.getValue() != null
                    && pantsColorComboBox.getValue() != null && pantsFitComboBox.getValue() != null
                    && pantsLengthComboBox.getValue() != null) {
                Pants pant = new Pants();
                order.getPantsList().add(pant);
                System.out.println("Pants added to the order!");
            } else {
                System.out.println("Please fill all the boxes before adding a pair of pants into your shoppingbag.");
            }
        });

        Label tShirtLabel = new Label("Create T-Shirt");
        //T-Shirt : Storlek, Material, Färg, Ärmar, Krage
        ComboBox<Size> tshirtSizeComboBox = createSizeComboBox();
        tshirtSizeComboBox.setVisible(false);

        ComboBox<Material> tshirtMaterialComboBox = createMaterialComboBox();
        tshirtMaterialComboBox.setVisible(false);

        ComboBox<Color> tshirtColorComboBox = createColorComboBox();
        tshirtColorComboBox.setVisible(false);

        ComboBox<Sleeves>  tshirtSleevesComboBox = createSleevesComboBox();
        tshirtSleevesComboBox.setVisible(false);

        ComboBox<Neck> tshirtNeckComboBox= createNeckComboBox();
        tshirtNeckComboBox.setVisible(false);

        Button addTshirtButton = new Button("Add T-Shirt");
        addTshirtButton.setOnAction(actionEvent -> {
            tshirtSizeComboBox.setVisible(true);
            tshirtMaterialComboBox.setVisible(true);
            tshirtColorComboBox.setVisible(true);
            tshirtSleevesComboBox.setVisible(true);
            tshirtNeckComboBox.setVisible(true);

            if (tshirtSizeComboBox.getValue() != null && tshirtMaterialComboBox.getValue() != null
                    && tshirtColorComboBox.getValue() != null && tshirtSleevesComboBox.getValue() != null
                    && tshirtNeckComboBox.getValue() != null) {
                TShirt tShirt = new TShirt();
                order.gettShirtList().add(tShirt);
                System.out.println("T-Shirt added to your order!");
            } else {
                System.out.println("Please fill in all the boxes before adding a T-Shirt into your shopping bag.");
            }
        });

        Label skirtLabel = new Label("Create skirt");
        // Skirt : Storlek, Material, Färg, Midja, Mönster
        ComboBox<Size> skirtSizeComboBox = createSizeComboBox();
        skirtSizeComboBox.setVisible(false);

        ComboBox<Material> skirtMaterialComboBox = createMaterialComboBox();
        skirtMaterialComboBox.setVisible(false);

        ComboBox<Color> skirtColorComboBox = createColorComboBox();
        skirtColorComboBox.setVisible(false);

        ComboBox<Waistline> skirtWaistlineComboBox = createWaistlineComboBox();
        skirtWaistlineComboBox.setVisible(false);

        ComboBox<Pattern> skirtPatternComboBox = createPatternComboBox();
        skirtPatternComboBox.setVisible(false);

        Button addSkirtButton = new Button("Add Skirt");
        addSkirtButton.setOnAction(actionEvent -> {
            skirtSizeComboBox.setVisible(true);
            skirtMaterialComboBox.setVisible(true);
            skirtColorComboBox.setVisible(true);
            skirtWaistlineComboBox.setVisible(true);
            skirtPatternComboBox.setVisible(true);

            if (skirtSizeComboBox.getValue() != null && skirtMaterialComboBox.getValue() != null
            && skirtColorComboBox.getValue() != null && skirtWaistlineComboBox.getValue() != null
            && skirtPatternComboBox.getValue() != null) {
                Skirt skirt = new Skirt();
                order.getSkirtList().add(skirt);
                System.out.println("Skirt added to your order.");
            } else {
                System.out.println("Please fill in all the boxes before adding a skirt into your shopping bag.");
            }
        });


        //Skapa new-order knapp
        Button placeOrderButton = new Button("Add to Order");
        placeOrderButton.setOnAction(actionEvent -> {
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
        HBox buttonBox = new HBox(30, placeOrderButton, completeOrderButton, addPantsButton, addTshirtButton, addSkirtButton);

        VBox pantsSection = new VBox(20, pantsLabel, pantsSizeComboBox, pantsMaterialComboBox,
                pantsColorComboBox, pantsFitComboBox, pantsLengthComboBox, addPantsButton);
        VBox tShirtSection = new VBox(20, tShirtLabel, tshirtSizeComboBox, tshirtMaterialComboBox,
                tshirtColorComboBox, tshirtSleevesComboBox, tshirtNeckComboBox, addTshirtButton);
        VBox skirtSection = new VBox(20, skirtLabel, skirtSizeComboBox, skirtMaterialComboBox,
                skirtColorComboBox, skirtWaistlineComboBox, skirtPatternComboBox, addSkirtButton);



        VBox root = new VBox(20, orderStatusLabel, buttonBox, pantsSection, tShirtSection, skirtSection);


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