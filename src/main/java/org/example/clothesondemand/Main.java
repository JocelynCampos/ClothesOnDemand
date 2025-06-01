package org.example.clothesondemand;


import commands.*;
import controllers.TrafficController;
import enums.*;
import models.*;
import observer.CEO;
import observer.CEOObserver;

import commands.FitCommand;
import commands.GarmentCommandPipeline;
import enums.Fit;

import java.util.List;

public class Main {
    public static void main (String [] args) {

        TrafficController trafficController = new TrafficController();

        CEOObserver ceoObserver = new CEOObserver();
        trafficController.addPropertyChangeListener(ceoObserver);

        CEO ceo = new CEO();
        trafficController.addPropertyChangeListener(ceo);

        //Pants
        GarmentCommandPipeline pantsPipeline = new GarmentCommandPipeline();
        Pants pants = new Pants();
        FitCommand fitCommand = new FitCommand(Fit.LOOSE, trafficController.getPropertyChangeSupport()); //In Production
        LengthCommand lengthCommand = new LengthCommand(Length.PETITE, trafficController.getPropertyChangeSupport()); //Produced
        pantsPipeline.addCommand(fitCommand);
        pantsPipeline.addCommand(lengthCommand);
        pantsPipeline.executeAll(pants);
        pants.setPrice(1200);

        //Tshirt
        GarmentCommandPipeline tshirtPipeline = new GarmentCommandPipeline();
        TShirt tshirt = new TShirt();
        NeckCommand neckCommand = new NeckCommand(Neck.ROUND, trafficController.getPropertyChangeSupport()); //In Production
        SleevesCommand sleevesCommand = new SleevesCommand(Sleeves.LONG_SLEEVE, trafficController.getPropertyChangeSupport()); //Produced
        tshirtPipeline.addCommand(neckCommand);
        tshirtPipeline.addCommand(sleevesCommand);
        tshirtPipeline.executeAll(tshirt);
        tshirt.setPrice(600);

        //Skirt
        GarmentCommandPipeline skirtPipeline = new GarmentCommandPipeline();
        Skirt skirt = new Skirt();
        WaistlineCommand waistlineCommand = new WaistlineCommand(Waistline.HIGH, trafficController.getPropertyChangeSupport());
        PatternCommand patternCommand = new PatternCommand(Pattern.DOTS, trafficController.getPropertyChangeSupport());
        skirtPipeline.addCommand(waistlineCommand);
        skirtPipeline.addCommand(patternCommand);
        skirtPipeline.executeAll(skirt);
        skirt.setPrice(800);

        GarmentCommandPipeline skirtPipeline2 = new GarmentCommandPipeline();
        Skirt skirt2 = new Skirt();
        WaistlineCommand waistlineCommand1 = new WaistlineCommand(Waistline.LOW, trafficController.getPropertyChangeSupport());
        PatternCommand patternCommand1 = new PatternCommand(Pattern.STRIPE, trafficController.getPropertyChangeSupport());
        skirtPipeline2.addCommand(waistlineCommand1);
        skirtPipeline2.addCommand(patternCommand1);
        skirtPipeline2.executeAll(skirt2);
        skirt2.setPrice(800);

        Order order = new Order(
                new Customer("Masha"),
                List.of(pants),
                List.of(tshirt),
                List.of(skirt, skirt2));

        order.addPropertyChangeListener(ceoObserver);
        order.addPropertyChangeListener(ceo);
        order.placeOrder();
        order.completedOrder();
        ceo.printSummary();


        Receipt receipt = order.createReceipt();
        receipt.printReceipt();
    }
}
