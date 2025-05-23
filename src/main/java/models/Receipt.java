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

    public String toString() {

        Map<String, List<Garments>> orderedGarments = new HashMap<>();
        for (Garments garment: itemsList) {
            String garmentName = garment.getName();
            orderedGarments.putIfAbsent(garmentName, new ArrayList<>());
            orderedGarments.get(garmentName).add(garment);
        }
        StringBuilder sb = new StringBuilder();
        double total = 0.0;
        sb.append("Receipt for ").append(customer.getName()).append("\n");

        for (Map.Entry<String, List<Garments>> entry : orderedGarments.entrySet()) {
            String garmentName = entry.getKey();
            List<Garments> garments = entry.getValue();
            int garmentQuantity = garments.size();
            double pricePerGarment = garments.get(0).getPrice();
            double subtotal = garmentQuantity * pricePerGarment;

            sb.append("\n")
                    .append(garmentName)
                    .append(" : " )
                    .append(garmentQuantity)
                    .append("\nPrice per item: ")
                    .append(pricePerGarment)
                    .append(" kr \n")
                    .append("Subtotal: ")
                    .append(subtotal)
                    .append(" kr\n");
            total += subtotal;
        }
        sb.append("\nTotal price for your purchase: ").append(total).append(" kr\n");
        sb.append("\nThank you for your order!");
        return sb.toString();
    }

    public void printReceipt() {
        System.out.println(toString());
    }
}
