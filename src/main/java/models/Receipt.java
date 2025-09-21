package models;

import java.util.ArrayList;
import java.util.List;

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

        StringBuilder receip = new StringBuilder();

        receip.append("********** RECEIPT **********\n");
        receip.append("Customer: ").append(customer.getName()).append("\n");

        double total = 0.0;
        for (Garments item : itemsList) {
            receip.append(String.format("%-10s: %.1f kr\n",
                    item.getName(), item.getPrice()));
            total += item.getPrice();
        }

        receip.append("Total price för your purchase: ").append(total).append(" kr\n");
        receip.append("************************************");

        return receip.toString();
    }

    public void printReceipt() {
        System.out.println(getFormattedSummary());
    }
}
