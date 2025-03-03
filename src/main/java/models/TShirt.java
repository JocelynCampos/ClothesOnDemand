package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import enums.*;

public class TShirt {
    private int id;
    private String name;
    private Size size;
    private Material material;
    private Color color;
    private Sleeves sleeves;
    private Neck neck;
    private double price;

    private PropertyChangeSupport propertyChangeSupport;

    public TShirt() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener (PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        Size oldSize = this.size;
        this.size = size;
        propertyChangeSupport.firePropertyChange("size", oldSize, this.size);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        Material oldMaterial = this.material;
        this.material = material;
        propertyChangeSupport.firePropertyChange("material", oldMaterial, this.material);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Color oldColor = this.color;
        this.color = color;
        propertyChangeSupport.firePropertyChange("color", oldColor, this.color);
    }

    public Sleeves getSleeves() {
        return sleeves;
    }

    public void setSleeves(Sleeves sleeves) {
        Sleeves oldSleeves = this.sleeves;
        this.sleeves = sleeves;
        propertyChangeSupport.firePropertyChange("sleeves", oldSleeves, this.sleeves);
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        Neck oldNeck = this.neck;
        this.neck = neck;
        propertyChangeSupport.firePropertyChange("neck", oldNeck, this.neck);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
