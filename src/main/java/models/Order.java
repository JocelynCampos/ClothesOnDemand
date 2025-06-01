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
    private String orderStatus;

    public Order (Customer customer, List<Pants> pants, List<TShirt> tShirts, List<Skirt> skirts) {
        this.id = counter++;
        this.customer = customer;
        this. pantsList = pants;
        this.tShirtList = tShirts;
        this.skirtList = skirts;
        this.orderStatus = "Order created";
    }

    public void addObserver (PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void placeOrder() {
        String oldStatus = this.orderStatus;
        this.orderStatus = "Clothing is being made for: " + customer.getName();

        support.firePropertyChange("orderStatus", oldStatus, this.orderStatus);
    }

    public void completedOrder(){
        String oldStatus = this.orderStatus;
        this.orderStatus = "Order ready for delivery: " + customer.getName();

    public List<Garments> getAllGarments() {
        List<Garments> allGarments = new ArrayList<>();
        allGarments.addAll(pantsList);
        allGarments.addAll(tShirtList);
        allGarments.addAll(skirtList);
        return allGarments;
    }

    public String getOrderStatus() {
        return orderStatus;
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
}
