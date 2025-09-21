package org.example.clothesondemand;

import commands.GarmentCommandPipeline;
import enums.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.*;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.control.TextArea;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.layout.Priority;

public class HelloApplication extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private Label orderStatusLabel;
    private Order order;


    @Override
    public void start(Stage stage) throws IOException {

        TabPane tabPane = new TabPane();

        //Skapar tom order
        order = new Order(null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        order.addPropertyChangeListener(new observer.CEO());

        //Label för orderstatus
        orderStatusLabel = new Label("Order status: " + order.getPlacedOrderStatus());

        /*****************BYXOR*******************************************/
        Label pantsLabel = new Label("Create pants");

        //Builder - Storlek, Material, Färg
        ComboBox<Size> pantsSizeComboBox = createSizeComboBox();
        ComboBox<Material> pantsMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> pantsColorComboBox = createColorComboBox();

        //Command - Fit & Length
        ComboBox<Fit> pantsFitComboBox = createFitComboBox();
        ComboBox<Length> pantsLengthComboBox = createLengthComboBox();


        VBox commandBoxPant = new VBox(10, new Label("Details"), pantsFitComboBox, pantsLengthComboBox);
        commandBoxPant.setVisible(false);
        commandBoxPant.setManaged(false);

        final Pants [] currentPants = new Pants[1];

        Button addPantsButton = new Button("Add pants");
        addPantsButton.setOnAction(actionEvent -> {
            if (!commandBoxPant.isVisible()) {
                if (pantsSizeComboBox.getValue() == null
                        || pantsMaterialComboBox.getValue() == null
                        || pantsColorComboBox.getValue() == null) {
                    System.out.println("Please choose size, material and color to proceed.");
                    return;
                }

                Pants pant = new builders.PantBuilder()
                        .setSize(pantsSizeComboBox.getValue())
                        .setMaterial(pantsMaterialComboBox.getValue())
                        .setColor(pantsColorComboBox.getValue())
                        .getResult();

                pant.setPrice(1000);
                currentPants[0] = pant;
                order.producingGarment(currentPants[0]);

                commandBoxPant.setVisible(true);
                commandBoxPant.setManaged(true);

                //Låser buildern
                pantsSizeComboBox.setDisable(true);
                pantsMaterialComboBox.setDisable(true);
                pantsColorComboBox.setDisable(true);

                System.out.println("Base Created. Choose Fit and Length. Then click 'Add pants' again to proceed");
                return;
            }

            if (pantsFitComboBox.getValue() == null || pantsLengthComboBox.getValue() == null) {
                System.out.println("Choose Fit and Length.");
                return;
            }
            GarmentCommandPipeline pantPipe = new commands.GarmentCommandPipeline()
                    .addCommand(new commands.FitCommand(pantsFitComboBox.getValue()))
                    .addCommand(new commands.LengthCommand(pantsLengthComboBox.getValue()));

            order.garmentFinished(currentPants[0], pantPipe);
            order.getPantsList().add(currentPants[0]);
            System.out.println("Pants added to the order!");

            currentPants[0] = null;
            pantsSizeComboBox.setDisable(false);
            pantsMaterialComboBox.setDisable(false);
            pantsColorComboBox.setDisable(false);

            commandBoxPant.setVisible(false);
            commandBoxPant.setManaged(false);
        });

        VBox pantsSection = new VBox(20, pantsLabel,
                pantsSizeComboBox, pantsMaterialComboBox, pantsColorComboBox,
                addPantsButton, commandBoxPant);
        ScrollPane pantScroll = new ScrollPane(pantsSection);
        pantScroll.setFitToWidth(true);
        pantScroll.setFitToHeight(true);

        Tab pantsTab = new Tab("Pants", pantScroll);

        /************Tshirt*****************/

        Label tShirtLabel = new Label("Create T-Shirt");

        //Builder - Storlek, Material, Färg
        ComboBox<Size> tShirtSizeComboBox = createSizeComboBox();
        ComboBox<Material> tShirtMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> tShirtColorComboBox = createColorComboBox();

        //Command
        ComboBox<Sleeves>  tShirtSleevesComboBox = createSleevesComboBox();
        ComboBox<Neck> tShirtNeckComboBox = createNeckComboBox();

        VBox commandBoxTshirt = new VBox(10, new Label("Details"), tShirtSleevesComboBox, tShirtNeckComboBox);
        commandBoxTshirt.setVisible(false);
        commandBoxTshirt.setManaged(false);

        final TShirt [] currentTShirt = new TShirt[1];

        Button addTshirtButton = new Button("Add T-Shirt");
        addTshirtButton.setOnAction(actionEvent -> {
            if (!commandBoxTshirt.isVisible()) {
                if (tShirtSizeComboBox.getValue() == null
                        || tShirtMaterialComboBox.getValue() == null
                        || tShirtColorComboBox.getValue() == null) {
                    System.out.println("Please choose size, material and color to proceed.");
                    return;
                }

                TShirt tShirt = new builders.TShirtBuilder()
                        .setSize(tShirtSizeComboBox.getValue())
                        .setMaterial(tShirtMaterialComboBox.getValue())
                        .setColor(tShirtColorComboBox.getValue())
                        .getResult();
                tShirt.setPrice(500);
                currentTShirt[0] = tShirt;
                order.producingGarment(currentTShirt[0]);

                commandBoxTshirt.setVisible(true);
                commandBoxTshirt.setManaged(true);

                //Lås buildern
                tShirtSizeComboBox.setDisable(true);
                tShirtMaterialComboBox.setDisable(true);
                tShirtColorComboBox.setDisable(true);

                System.out.println("Base Created. Choose neck and sleeves. Then click 'Add tshirt' again to proceed");
                return;
            }

            if (tShirtNeckComboBox.getValue() == null || tShirtSleevesComboBox.getValue() == null) {
                System.out.println("Choose neck and sleeves.");
                return;
            }

            GarmentCommandPipeline tShirtPipe = new commands.GarmentCommandPipeline()
                    .addCommand(new commands.NeckCommand(tShirtNeckComboBox.getValue()))
                    .addCommand(new commands.SleevesCommand(tShirtSleevesComboBox.getValue()));
            order.garmentFinished(currentTShirt[0], tShirtPipe);
            order.getTShirtList().add(currentTShirt[0]);
            System.out.println("T-Shirt added to the order!");

            currentTShirt[0] = null;
            tShirtSizeComboBox.setDisable(false);
            tShirtMaterialComboBox.setDisable(false);
            tShirtColorComboBox.setDisable(false);

            commandBoxTshirt.setVisible(false);
            commandBoxTshirt.setManaged(false);
        });

        VBox tShirtSection = new VBox(20, tShirtLabel,
                tShirtSizeComboBox, tShirtMaterialComboBox, tShirtColorComboBox,
                addTshirtButton, commandBoxTshirt);
        ScrollPane tShirtScroll = new ScrollPane(tShirtSection);
        tShirtScroll.setFitToWidth(true);
        tShirtScroll.setFitToHeight(true);
        Tab tShirtTab = new Tab("T-Shirt", tShirtScroll);

        /**************Skirt******************/

        Label skirtLabel = new Label("Create skirt");

        // Builder
        ComboBox<Size> skirtSizeComboBox = createSizeComboBox();
        ComboBox<Material> skirtMaterialComboBox = createMaterialComboBox();
        ComboBox<Color> skirtColorComboBox = createColorComboBox();

        //Command
        ComboBox<Waistline> skirtWaistlineComboBox = createWaistlineComboBox();
        ComboBox<Pattern> skirtPatternComboBox = createPatternComboBox();

        VBox commandBoxSkirt = new VBox(5, new Label("Details"), skirtPatternComboBox, skirtWaistlineComboBox);
        commandBoxSkirt.setVisible(false);
        commandBoxSkirt.setManaged(false);

        final Skirt [] currentSkirt = new Skirt[1];

        Button addSkirtButton = new Button("Add Skirt");
        addSkirtButton.setOnAction(actionEvent -> {
            if (!commandBoxSkirt.isVisible()) {
                if (skirtSizeComboBox.getValue() == null
                        || skirtMaterialComboBox.getValue() == null
                        || skirtColorComboBox.getValue() == null) {
                    System.out.println("Please choose size, material and color to proceed.");
                    return;
                }

                Skirt skirt = new builders.SkirtBuilder()
                        .setSize(skirtSizeComboBox.getValue())
                        .setMaterial(skirtMaterialComboBox.getValue())
                        .setColor(skirtColorComboBox.getValue())
                        .getResult();
                skirt.setPrice(600);
                currentSkirt[0] = skirt;
                order.producingGarment(currentSkirt[0]);

                commandBoxSkirt.setVisible(true);
                commandBoxSkirt.setManaged(true);

                //Lås buildern
                skirtSizeComboBox.setDisable(true);
                skirtMaterialComboBox.setDisable(true);
                skirtColorComboBox.setDisable(true);

                System.out.println("Base Created. Choose pattern and waistline. Then click 'Add skirt' again to proceed");
                return;
            }

            if (skirtPatternComboBox.getValue() == null || skirtWaistlineComboBox.getValue() == null) {
                System.out.println("Choose pattern and waistline.");
                return;
            }

            GarmentCommandPipeline skirtPipe = new commands.GarmentCommandPipeline()
                    .addCommand(new commands.PatternCommand(skirtPatternComboBox.getValue()))
                    .addCommand(new commands.WaistlineCommand(skirtWaistlineComboBox.getValue()));

            order.garmentFinished(currentSkirt[0], skirtPipe);
            order.getSkirtList().add(currentSkirt[0]);
            System.out.println("Skirt added to your order!");

            currentSkirt[0] = null;
            skirtSizeComboBox.setDisable(false);
            skirtMaterialComboBox.setDisable(false);
            skirtColorComboBox.setDisable(false);

            commandBoxSkirt.setVisible(false);
            commandBoxSkirt.setManaged(false);
        });


        VBox skirtSection = new VBox(20, skirtLabel,
                skirtSizeComboBox, skirtMaterialComboBox, skirtColorComboBox,
                addSkirtButton, commandBoxSkirt);
        ScrollPane skirtScroll = new ScrollPane(skirtSection);
        skirtScroll.setFitToWidth(true);
        skirtScroll.setFitToHeight(true);

        Tab skirtTab = new Tab("Skirt", skirtScroll);


        TextArea summaryTextArea = new TextArea();
        summaryTextArea.setEditable(false);


        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        Label addressLabel = new Label("Address");
        TextField addressField = new TextField();
        Label mailLabel = new Label("Mail");
        TextField mailField = new TextField();

        Button saveCustomerButton = new Button("Save Customer");

        saveCustomerButton.setOnAction(actionEvent -> {
            String customerName = nameField.getText();
            String customerAddress = addressField.getText();
            String customerMail = mailField.getText();
            if (!customerName.isEmpty() && !customerAddress.isEmpty() && !customerMail.isEmpty()) {
                Customer customer = new Customer(customerName);
                customer.setAddress(customerAddress);
                customer.setMail(customerMail);

                order.setCustomer(customer);

                System.out.println("Customer: " + customer.getName() + " saved.");
                System.out.println("Customers adress: " + customer.getAddress() + "\nMail: " + customer.getMail());
            } else {
                System.out.println("All fields need to be filled before proceeding.");
            }
        });

        VBox customerSection = new VBox(10, nameLabel, nameField, addressLabel, addressField, mailLabel, mailField, saveCustomerButton);
        Tab customerTab = new Tab("Customer information: ", customerSection);


        /**Button showSummaryButton = new Button("Show summary");
        showSummaryButton.setOnAction(actionEvent -> {
            StringBuilder summary = new StringBuilder();
            for (Garments garments : order.getAllGarments()) {
                summary.append(garments.getName()).append(": ").append(garments.getPrice()).append("kr\n");
            }
            summaryTextArea.setText(summary.toString());
        });*/

        VBox showSummarySection = new VBox(20,summaryTextArea);
        ScrollPane summaryScroll = new ScrollPane(showSummarySection);
        summaryScroll.setFitToWidth(true);
        summaryScroll.setFitToHeight(true);

        Tab summaryTab = new Tab("Order summary:", summaryScroll);
        tabPane.getTabs().addAll(customerTab,pantsTab,tShirtTab,skirtTab,summaryTab);


        //Skapa newOrder knapp
        Button placeOrderButton = new Button("Add to Order");
        placeOrderButton.setOnAction(actionEvent -> {
            order.placeOrder();
            orderStatusLabel.setText("Order status" + order.getPlacedOrderStatus());
        });

        //Spara beställning knapp
        Button completeOrderButton = new Button("Complete order");
        completeOrderButton.setOnAction(actionEvent -> {
            if (order.getCustomer() != null) {
                order.completedOrder();
                orderStatusLabel.setText("Order Status: " + order.getPlacedOrderStatus());
                Receipt receipt = order.createReceipt();
                summaryTextArea.setText(receipt.getFormattedSummary());
            }
            else {
                throw new IllegalStateException("Customer can't be null!");
            }

        });


        //Knappar
        HBox buttonBox = new HBox(40, placeOrderButton, completeOrderButton, addPantsButton, addTshirtButton, addSkirtButton);

        VBox root = new VBox(40, orderStatusLabel, buttonBox, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);

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