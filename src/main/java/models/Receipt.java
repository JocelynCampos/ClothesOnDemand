package models;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    public Receipt () {
    }

    private List<Garments> itemsList = new ArrayList<Garments>();

    public void addGarment(Garments item) {
        itemsList.add(item);
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        double total = 0;

        for (Garments garment : itemsList) {
            System.out.println("- " + garment.getName() + " | Price: " + garment.getPrice() + " kr");
            total += garment.getPrice();
        }
        System.out.println("Total: " + total + "kr.");
        System.out.println("Thank you for your order!");
    }

}
