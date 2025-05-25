package modeltests;

import builders.PantBuilder;
import builders.SkirtBuilder;
import builders.TshirtBuilder;
import enums.*;
import models.*;
import observer.CEO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void orderTest() {

        //
        //Skapa byxa 1
        PantBuilder pantsTest1 = new PantBuilder();
        pantsTest1.setSize(Size.SMALL);
        pantsTest1.setMaterial(Material.COTTON);
        pantsTest1.setColor(Color.DARK_GREEN);
        pantsTest1.setFit(Fit.LOOSE);
        pantsTest1.setLength(Length.PETITE);
        Pants pants = pantsTest1.getResult();
        pants.setPrice(1000);

        //Byxa 2
        PantBuilder pantsTest2 = new PantBuilder();
        pantsTest2.setSize(Size.LARGE);
        pantsTest2.setMaterial(Material.LINEN);
        pantsTest2.setColor(Color.VELVET_RED);
        pantsTest2.setFit(Fit.SLIM);
        pantsTest2.setLength(Length.TALL);
        Pants pants2 = pantsTest2.getResult();
        pants2.setPrice(1000);

        //Skapa tshirt 1
        TshirtBuilder tshirtTest1 = new TshirtBuilder();
        tshirtTest1.setSize(Size.MEDIUM);
        tshirtTest1.setMaterial(Material.LINEN);
        tshirtTest1.setColor(Color.KOBOLT_BLUE);
        tshirtTest1.setSleeves(Sleeves.SHORT_SLEEVE);
        tshirtTest1.setNeck(Neck.ROUND);
        TShirt tshirt = tshirtTest1.getResult();
        tshirt.setPrice(500);

        //tskirt 2
        TshirtBuilder tshirtTest2 = new TshirtBuilder();
        tshirtTest2.setSize(Size.SMALL);
        tshirtTest2.setMaterial(Material.WOOL);
        tshirtTest2.setColor(Color.KOBOLT_BLUE);
        tshirtTest2.setSleeves(Sleeves.LONG_SLEEVE);
        tshirtTest2.setNeck(Neck.POLO);
        TShirt tshirt2 = tshirtTest2.getResult();
        tshirt2.setPrice(500);


        //Skapa kjol
        SkirtBuilder skirtTest1 = new SkirtBuilder();
        skirtTest1.setSize(Size.MEDIUM);
        skirtTest1.setMaterial(Material.WOOL);
        skirtTest1.setColor(Color.VELVET_RED);
        skirtTest1.setWaistline(Waistline.HIGH);
        skirtTest1.setPattern(Pattern.DOTS);
        Skirt skirt = skirtTest1.getResult();
        skirt.setPrice(900);

        List<Pants> pantsList  = new ArrayList<>();
        pantsList.add(pants);

        List<TShirt> tshirtList  = new ArrayList<>();
        tshirtList.add(tshirt);

        List<Skirt> skirtList  = new ArrayList<>();
        skirtList.add(skirt);

        //Skapa kund 1
        Customer customer1 = new Customer("Customer Customersson");
        Customer customer2 = new Customer("Test Testsson");

        //Skapa order
        Order order1 = new Order(customer1, pantsList, tshirtList, skirtList);
        Order order2 = new Order(customer2, pantsList, tshirtList, skirtList);

        //CEO
        CEO ceo = new CEO();
        //order1.addObserver(ceo);
        order1.completedOrder();
        //order2.addObserver(ceo);
        order2.completedOrder();

        ceo.printSummary();

        //Skapa kvitto
        Receipt receipt1 = order1.createReceipt();
        Receipt receipt2 = order2.createReceipt();


        String[] receiptLine = receipt1.toString().split("\n");
        String[] receiptLine2 = receipt2.toString().split("\n");


        System.out.println("RECEIPT 1: \n" + receipt1.toString() + "\n---");
        System.out.println("RECEIPT 2: \n" + receipt2.toString() + "\n---");


        //Addera priserna order 1
        List<Order> allOrders = List.of(order1, order2);
        double expectedTotalPrice = 500 + 500 + 900 + 900 + 1000 + 1000;
        double total = 0;
        for (Order order : allOrders) {
            for (Garments garments : order.getAllGarments()) {
                total += garments.getPrice();
            }
        }


        //Jämför summan
        Assertions.assertTrue(receipt1.toString().contains("Customer Customersson"));
        Assertions.assertTrue(receipt2.toString().contains("Test Testsson"));
        Assertions.assertEquals(expectedTotalPrice, total);
        Assertions.assertEquals(expectedTotalPrice, ceo.getTotalIncome());
        Assertions.assertEquals(6, ceo.getAmountOfGarmentsSold());

    }
}
