package models;

import commands.GarmentCommandPipeline;
import utilities.Events;

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

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private String placedOrderStatus;

    public Order (Customer customer, List<Pants> pants, List<TShirt> tShirts, List<Skirt> skirts) {
        this.id = counter++;
        this.customer = customer;
        this. pantsList = (pants != null) ? new ArrayList<>(pants): new ArrayList<>();
        this.tShirtList = (tShirts != null) ? new ArrayList<>(tShirts) : new ArrayList<>();
        this.skirtList = (skirts != null) ? new ArrayList<>(skirts) : new ArrayList<>();
        this.placedOrderStatus = "Order Created";
    }

    //Observers
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void placeOrder() {
        String oldStatus = this.placedOrderStatus;
        this.placedOrderStatus = "Clothing is being made for: " + customer.getName();

        pcs.firePropertyChange(Events.PLACED_ORDER, oldStatus, this.placedOrderStatus);
    }

    public void producingGarment(Garments garment) {
        pcs.firePropertyChange(Events.PRODUCING_GARMENT, null, garment);

    }

    public void garmentFinished(Garments garment, GarmentCommandPipeline pipeline) {
        pcs.firePropertyChange(Events.GARMENT_FINISHED, null, garment);
        if (pipeline != null) {
            pipeline.executeAll(garment);
            pipeline.clear();
        }
    }

    public void completedOrder(){
        String oldStatus = this.placedOrderStatus;
        this.placedOrderStatus = "Order ready for delivery: " + customer.getName();

        pcs.firePropertyChange(Events.ORDER_FINISHED, oldStatus, this.placedOrderStatus);
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

    public List<TShirt> getTShirtList() {
        return tShirtList;
    }

    public List<Skirt> getSkirtList() {
        return skirtList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setPlacedOrderStatus(String placedOrderStatus) {
        this.placedOrderStatus = placedOrderStatus;
    }
}
