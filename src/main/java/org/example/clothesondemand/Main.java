package org.example.clothesondemand;


import commands.*;
import controllers.TrafficController;
import enums.*;
import interfaces.GarmentCommand;
import models.Pants;
import models.Skirt;
import models.TShirt;
import observer.CEO;
import observer.CEOObserver;

import commands.FitCommand;
import commands.GarmentCommandPipeline;
import enums.Fit;

public class Main {
    public static void main (String [] args) {

        TrafficController trafficController = new TrafficController();
        GarmentCommandPipeline pantsPipeline = new GarmentCommandPipeline();
        GarmentCommandPipeline tshirtPipeline = new GarmentCommandPipeline();
        GarmentCommandPipeline skirtPipeline = new GarmentCommandPipeline();

        CEOObserver ceoObserver = new CEOObserver();
        trafficController.addPropertyChangeListener(ceoObserver);

        //Pants
        Pants pants = new Pants();
        FitCommand fitCommand = new FitCommand(Fit.LOOSE, trafficController.getPropertyChangeSupport()); //In Production
        LengthCommand lengthCommand = new LengthCommand(Length.PETITE, trafficController.getPropertyChangeSupport()); //Produced
        pantsPipeline.addCommand(fitCommand);
        pantsPipeline.addCommand(lengthCommand);
        pantsPipeline.executeAll(pants);

        //Tshirt
        TShirt tshirt = new TShirt();
        NeckCommand neckCommand = new NeckCommand(Neck.ROUND, trafficController.getPropertyChangeSupport()); //In Production
        SleevesCommand sleevesCommand = new SleevesCommand(Sleeves.LONG_SLEEVE, trafficController.getPropertyChangeSupport()); //Produced
        tshirtPipeline.addCommand(neckCommand);
        tshirtPipeline.addCommand(sleevesCommand);
        tshirtPipeline.executeAll(tshirt);

        //Skirt
        Skirt skirt = new Skirt();
        WaistlineCommand waistlineCommand = new WaistlineCommand(Waistline.HIGH, trafficController.getPropertyChangeSupport());
        PatternCommand patternCommand = new PatternCommand(Pattern.DOTS, trafficController.getPropertyChangeSupport());
        skirtPipeline.addCommand(waistlineCommand);
        skirtPipeline.addCommand(patternCommand);
        skirtPipeline.executeAll(skirt);


        GarmentCommandPipeline produceGarmentPipeline = new GarmentCommandPipeline();
    }
}
