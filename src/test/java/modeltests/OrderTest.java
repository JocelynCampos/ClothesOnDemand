package modeltests;

import GarmentBuilders.PantBuilder;
import GarmentBuilders.SkirtBuilder;
import GarmentBuilders.TshirtBuilder;
import enums.*;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void orderTest() {

        //Skapa byxa
        PantBuilder pantsTest = new PantBuilder();
        pantsTest.setSize(Size.SMALL);
        pantsTest.setMaterial(Material.COTTON);
        pantsTest.setColor(Color.DARK_GREEN);
        pantsTest.setFit(Fit.LOOSE);
        pantsTest.setLength(Length.PETITE);
        Pants pants = pantsTest.getResult();
        pants.setPrice(1000);

        //Skapa tshirt
        TshirtBuilder tshirtTest = new TshirtBuilder();
        tshirtTest.setSize(Size.MEDIUM);
        tshirtTest.setMaterial(Material.LINEN);
        tshirtTest.setColor(Color.KOBOLT_BLUE);
        tshirtTest.setSleeves(Sleeves.SHORT_SLEEVE);
        tshirtTest.setNeck(Neck.ROUND);
        TShirt tshirt = tshirtTest.getResult();
        tshirt.setPrice(500);


        //Skapa kjol
        SkirtBuilder skirtTest = new SkirtBuilder();
        skirtTest.setSize(Size.MEDIUM);
        skirtTest.setMaterial(Material.WOOL);
        skirtTest.setColor(Color.VELVET_RED);
        skirtTest.setWaistline(Waistline.HIGH);
        skirtTest.setPattern(Pattern.DOTS);
        Skirt skirt = skirtTest.getResult();
        skirt.setPrice(900);

        List<Pants> pantsList  = new ArrayList<>();
        pantsList.add(pants);

        List<TShirt> tshirtList  = new ArrayList<>();
        tshirtList.add(tshirt);

        List<Skirt> skirtList  = new ArrayList<>();
        skirtList.add(skirt);

        //Skapa kund
        Customer customer = new Customer("Customer Customersson");

        //Skapa order
        Order order = new Order(customer, pantsList, tshirtList, skirtList);

        //CEO
        CEO ceo = new CEO();
        order.addObserver(ceo);
        order.completedOrder();

        //Skapa kvitto
        Receipt receipt = order.createReceipt();

        //Addera priserna
        double expectedTotalPrice = 500 + 900 + 1000;
        double total = 0;
        for (Garments garments : order.getAllGarments()) {
            total += garments.getPrice();
        }

        //Jämför summan
        Assertions.assertEquals(expectedTotalPrice, total);
        Assertions.assertEquals(expectedTotalPrice, ceo.getTotalIncome());
        Assertions.assertEquals(3, ceo.getAmountOfGarmentsSold());

    }
}
