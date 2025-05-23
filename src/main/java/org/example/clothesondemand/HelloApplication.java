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
import java.awt.TextArea;
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

        TabPane tabPane = new TabPane();

        //Skapar tom order
        order = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        CEO ceo = new CEO();

        //Label för orderstatus
        orderStatusLabel = new Label("Order status: " + order.getOrderStatus());

        /*****************BYXOR*******************************************/
        Label pantsLabel = new Label("Create pants");
        //Storlek, Material, Färg, PassForm, Längd
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
                pant.setSize(pantsSizeComboBox.getValue());
                pant.setMaterial(pantsMaterialComboBox.getValue());
                pant.setColor(pantsColorComboBox.getValue());
                pant.setFit(pantsFitComboBox.getValue());
                pant.setLength(pantsLengthComboBox.getValue());
                pant.setPrice(1200);

                order.getPantsList().add(pant);
                System.out.println("Pants added to the order!");
            } else {
                System.out.println("Please fill all the boxes before adding a pair of pants into your shoppingbag.");
            }
        });
        VBox pantsSection = new VBox(20, pantsLabel, pantsSizeComboBox, pantsMaterialComboBox,
                pantsColorComboBox, pantsFitComboBox, pantsLengthComboBox, addPantsButton);
        Tab pantsTab = new Tab("Pants", pantsSection);

        /************Tshirt*****************/

        Label tShirtLabel = new Label("Create T-Shirt");
        // Storlek, Material, Färg, Ärmar, Krage
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
                tShirt.setSize(tshirtSizeComboBox.getValue());
                tShirt.setMaterial(tshirtMaterialComboBox.getValue());
                tShirt.setColor(tshirtColorComboBox.getValue());
                tShirt.setNeck(tshirtNeckComboBox.getValue());
                tShirt.setSleeves(tshirtSleevesComboBox.getValue());
                tShirt.setPrice(600);

                order.gettShirtList().add(tShirt);
                System.out.println("T-Shirt added to your order!");
            } else {
                System.out.println("Please fill in all the boxes before adding a T-Shirt into your shopping bag.");
            }
        });

        VBox tShirtSection = new VBox(20, tShirtLabel, tshirtSizeComboBox, tshirtMaterialComboBox,
                tshirtColorComboBox, tshirtSleevesComboBox, tshirtNeckComboBox, addTshirtButton);
        Tab tShirtTab = new Tab("T-Shirt", tShirtSection);

        /**************Skirt******************/

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
                skirt.setSize(skirtSizeComboBox.getValue());
                skirt.setMaterial(skirtMaterialComboBox.getValue());
                skirt.setColor(skirtColorComboBox.getValue());
                skirt.setWaistline(skirtWaistlineComboBox.getValue());
                skirt.setPattern(skirtPatternComboBox.getValue());
                skirt.setPrice(800);

                order.getSkirtList().add(skirt);
                System.out.println("Skirt added to your order.");
            } else {
                System.out.println("Please fill in all the boxes before adding a skirt into your shopping bag.");
            }
        });


        VBox skirtSection = new VBox(20, skirtLabel, skirtSizeComboBox, skirtMaterialComboBox,
                skirtColorComboBox, skirtWaistlineComboBox, skirtPatternComboBox, addSkirtButton);

        Tab skirtTab = new Tab("Skirt", skirtSection);


        TextArea summaryTextArea = new TextArea();
        summaryTextArea.setEditable(false);

        Button showSummaryButton = new Button("Show summary");
        showSummaryButton.setOnAction(actionEvent -> {
            StringBuilder summary = new StringBuilder();
            for (Garments garments : order.getAllGarments()) {
                summary.append(garments.getName()).append(": ").append(garments.getPrice()).append("kr\n");
            }
            summaryTextArea.setText(summary.toString());
        });


        Tab summaryTab = new Tab("Order Summary");



        //Skapa newOrder knapp
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
        HBox buttonBox = new HBox(40, placeOrderButton, completeOrderButton, addPantsButton, addTshirtButton, addSkirtButton);

        tabPane.getTabs().addAll(pantsTab, tShirtTab, skirtTab, summaryTab);


        HBox garmentRow = new HBox(40, pantsSection, tShirtSection ,skirtSection);
        VBox root = new VBox(40, orderStatusLabel, buttonBox, garmentRow);
        pantsSection.setPrefWidth(WIDTH/3.2);
        tShirtSection.setPrefWidth(WIDTH/3.2);
        skirtSection.setPrefWidth(WIDTH/3.2);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Clothes on Demand");
        stage.setScene(scene);
        stage.show();


        }

    //ComboBoxes för de tre plaggens delade attribut
    public ComboBox<Size> createSizeComboBox() {
        ComboBox<Size> sizeComboBox = new ComboBox<>();
        sizeComboBox.getItems().addAll(Size.values());
        sizeComboBox.setPromptText("Choose Size");
        return sizeComboBox;
    }

    public ComboBox<Material> createMaterialComboBox() {
        ComboBox<Material> materialComboBox = new ComboBox<>();
        materialComboBox.getItems().addAll(Material.values());
        materialComboBox.setPromptText("Choose Material");
        return materialComboBox;
    }

    public ComboBox<Color> createColorComboBox() {
        ComboBox<Color> colorComboBox = new ComboBox<>();
        colorComboBox.getItems().addAll(Color.values());
        colorComboBox.setPromptText("Choose Color");
        return colorComboBox;
    }

    //Extra ComboBoxes för Pants
    public ComboBox<Fit> createFitComboBox() {
        ComboBox<Fit> fitComboBox = new ComboBox<>();
        fitComboBox.getItems().addAll(Fit.values());
        fitComboBox.setPromptText("Choose Fit");
        return fitComboBox;
    }

    public ComboBox<Length> createLengthComboBox() {
        ComboBox<Length> lengthComboBox = new ComboBox<>();
        lengthComboBox.getItems().addAll(Length.values());
        lengthComboBox.setPromptText("Choose Length");
        return lengthComboBox;
    }


    //Extra ComboBoxes för T-Shirt
    public ComboBox<Sleeves> createSleevesComboBox() {
        ComboBox<Sleeves> sleevesComboBox = new ComboBox<>();
        sleevesComboBox.getItems().addAll(Sleeves.values());
        sleevesComboBox.setPromptText("Choose Sleeves");
        return sleevesComboBox;
    }

    public ComboBox<Neck> createNeckComboBox() {
        ComboBox<Neck> neckComboBox = new ComboBox<>();
        neckComboBox.getItems().addAll(Neck.values());
        neckComboBox.setPromptText("Choose Neck");
        return neckComboBox;
    }

    //Extra ComboBoxes för Skirt
    public ComboBox<Waistline> createWaistlineComboBox() {
        ComboBox<Waistline> waistlineComboBox = new ComboBox<>();
        waistlineComboBox.getItems().addAll(Waistline.values());
        waistlineComboBox.setPromptText("Choose Waistline");
        return waistlineComboBox;
    }

    public ComboBox<Pattern> createPatternComboBox() {
        ComboBox<Pattern> patternComboBox = new ComboBox<>();
        patternComboBox.getItems().addAll(Pattern.values());
        patternComboBox.setPromptText("Choose Pattern");
        return patternComboBox;
    }





    public static void main(String[] args) {
        launch();
    }
}