package observer;

import models.Garments;
import models.Order;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {

    private int amountOfGarmentsSold = 0;
    private double totalIncome = 0;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if(evt.getNewValue().toString().contains("ready for delivery")) {
            Order order = (Order) evt.getSource();

            int garments = order.getAllGarments().size();
            amountOfGarmentsSold += garments;

            double orderTotal = 0;
            for (Garments garments1 : order.getAllGarments()) {
                orderTotal += garments1.getPrice();
            }
            totalIncome += orderTotal;
        }
    }

    public int getAmountOfGarmentsSold() {
        return amountOfGarmentsSold;

    }

    public double getTotalIncome() {
        return totalIncome;

    }

    public void printSummary() {
        System.out.println("******** Order Summary ********");
        System.out.println("Amount of garments sold: " + amountOfGarmentsSold);
        System.out.println("Total income: " + totalIncome);
        System.out.println("******** CEO INFORMATION FINISHED ********\n");
    }
}


