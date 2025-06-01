package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int id;
    private Customer customer;
    private List<Pants> pantsList;
    private List<TShirt> tShirtList;
    private List<Skirt> skirtList;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    private String placedOrderStatus;
    //private String finishedOrderStatus;

    public Order (Customer customer, List<Pants> pants, List<TShirt> tShirts, List<Skirt> skirts) {
        this.id = counter++;
        this.customer = customer;
        this. pantsList = pants;
        this.tShirtList = tShirts;
        this.skirtList = skirts;
        this.placedOrderStatus = "Order Created";
    }

    public void placeOrder() {
        String oldStatus = this.placedOrderStatus;
        this.placedOrderStatus = "Clothing is being made for: " + customer.getName();

        support.firePropertyChange("Placed Order", oldStatus, this.placedOrderStatus);
    }

    public void completedOrder(){
        String oldStatus = this.placedOrderStatus;
        this.placedOrderStatus = "Order ready for delivery: " + customer.getName();

        support.firePropertyChange("Finished Order", oldStatus, this.placedOrderStatus);
    }

    public List<Garments> getAllGarments() {
        List<Garments> allGarments = new ArrayList<>();
        allGarments.addAll(pantsList);
        allGarments.addAll(tShirtList);
        allGarments.addAll(skirtList);
        return allGarments;
    }

    public String getPlacedOrderStatus() {
        return placedOrderStatus;
    }

    public Receipt createReceipt() {
        Receipt receipt = new Receipt(customer);
        for (Garments garment: getAllGarments()) {
            receipt.addGarment(garment);
        }
        return receipt;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pants> getPantsList() {
        return pantsList;
    }

    public List<TShirt> gettShirtList() {
        return tShirtList;
    }

    public List<Skirt> getSkirtList() {
        return skirtList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
