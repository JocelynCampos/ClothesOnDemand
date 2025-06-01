package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {

    private Customer customer;
    private List<Garments> itemsList = new ArrayList<>();

    public Receipt (Customer customer) {
        this.customer = customer;
    }

    public void addGarment(Garments item) {
        itemsList.add(item);
    }

    public String getFormattedSummary() {

        StringBuilder receiptString = new StringBuilder();

        receiptString.append("********** RECEIPT **********\n");
        receiptString.append("Customer: ").append(customer.getName()).append("\n");

        double total = 0.0;
        for (Garments item : itemsList) {
            receiptString.append(String.format("%-10s: %.1f kr\n",
                    item.getName(), item.getPrice()));
            total += item.getPrice();
        }

        receiptString.append("Total price för your purchase: ").append(total).append(" kr\n");
        receiptString.append("************************************");

        return receiptString.toString();
    }

    public void printReceipt() {
        System.out.println(getFormattedSummary());
    }
}
