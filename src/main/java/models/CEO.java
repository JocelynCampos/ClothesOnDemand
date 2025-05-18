package models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {

    private int amountOfGarmentsSold = 0;
    private double totalIncome = 0;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("*** CEO information ***");
        System.out.println("Orderstatus: " + evt.getNewValue());

        if(evt.getNewValue().toString().contains("ready for delivery")) {
            Order order = (Order) evt.getSource();

            int garments = order.getAllGarments().size();
            amountOfGarmentsSold += garments;

            double orderTotal = 0;
            for (Garments garments1 : order.getAllGarments()) {
                orderTotal += garments1.getPrice();
            }
            totalIncome += orderTotal;

            System.out.println("Order with " + garments + " garments. Total for order: " + orderTotal);
            System.out.println("Amount of garments sold: " + amountOfGarmentsSold);
            System.out.println("Total income: " + totalIncome + " kr.");
        }
    }

    public int getAmountOfGarmentsSold() {
        return amountOfGarmentsSold;

    }

    public double getTotalIncome() {
        return totalIncome;

    }
}


