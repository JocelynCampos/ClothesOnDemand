package org.example.clothesondemand;

import controllers.TrafficController;
import enums.*;
import models.Pants;
import models.Skirt;
import models.TShirt;

public class Main {
    public static void main (String [] args) {

        TrafficController trafficController = new TrafficController();

        Pants pants = new Pants();
        pants.addPropertyChangeListener(trafficController);

        TShirt tShirt = new TShirt();
        tShirt.addPropertyChangeListener(trafficController);

        Skirt skirt = new Skirt();
        skirt.addPropertyChangeListener(trafficController);

        System.out.println("Pants");
        pants.setSize(Size.LARGE);
        pants.setMaterial(Material.COTTON);
        pants.setColor(Color.DARK_GREEN);
        pants.setFit(Fit.SLIM);
        pants.setLength(Length.PETITE);
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.println("T-Shirt");
        tShirt.setSize(Size.MEDIUM);
        tShirt.setMaterial(Material.LINEN);
        tShirt.setColor(Color.KOBOLT_BLUE);
        tShirt.setSleeves(Sleeves.SHORT_SLEEVE);
        tShirt.setNeck(Neck.ROUND);
        System.out.println("----------------------------------------");
        System.out.println();


        System.out.println("Skirt");
        skirt.setSize(Size.SMALL);
        skirt.setMaterial(Material.WOOL);
        skirt.setColor(Color.VELVET_RED);
        skirt.setWaistline(Waistline.HIGH);
        skirt.setPattern(Pattern.DOTS);
        System.out.println("----------------------------------------");
        System.out.println();

    }
}
