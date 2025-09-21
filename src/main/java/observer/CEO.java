package observer;

import models.Garments;
import models.Order;
import utilities.Events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {

    private int amountOfGarmentsSold = 0;
    private double totalIncome = 0;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("_____________________________________________________________");
        try {
            System.out.println("[NOTIFY] Event; " + evt.getPropertyName());
            if (evt.getNewValue() instanceof Garments garment) {
                System.out.println(" -> " + garment.getName() + " (#" + garment.getId() + ")");
            }

            switch (evt.getPropertyName()) {
                case (Events.PLACED_ORDER) -> {
                    System.out.println("A new order has been placed");
                }
                case (Events.PRODUCING_GARMENT) -> {
                    Garments garmentBeingProduced = (Garments) evt.getNewValue();
                    System.out.println("Started a production of " + garmentBeingProduced.getName()
                            + ":" + garmentBeingProduced.getId() + ", " + garmentBeingProduced.getSize() + ", " + garmentBeingProduced.getColor() + ", " + garmentBeingProduced.getMaterial() + ".");
                }
                case (Events.GARMENT_FINISHED) -> {
                    Garments garmentBeingFinished = (Garments) evt.getNewValue();
                    System.out.println("Garment finished.");
                    System.out.println("Total price: " + (int) garmentBeingFinished.getPrice() + " kr.");

                    amountOfGarmentsSold++;
                    totalIncome += garmentBeingFinished.getPrice();
                }
                case (Events.ORDER_FINISHED) -> {
                    Order order = (Order) evt.getSource();

                    double orderTotal = order.getAllGarments()
                            .stream()
                            .mapToDouble(Garments::getPrice)
                            .sum();
                    System.out.println("Order ready for delivery.\nTotal: " + (int) orderTotal + " kr.");
                    printSummary();
                }
                default -> {
                    System.out.println("Unknoen event " + evt.getPropertyName());
                }
            }
        }
        finally {
            System.out.println("_____________________________________________________________");
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


