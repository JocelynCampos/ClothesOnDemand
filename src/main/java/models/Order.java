package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    }

    public void addObserver (PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void placeOrder() {
        String oldStatud = this.orderStatus;
        this.orderStatus = "Clothing is being made: " + customer.getName();
    }


    public String getName() {
        return orderStatus;
    }

    public void setName(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
