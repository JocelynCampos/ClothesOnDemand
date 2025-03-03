package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import enums.*;

public class Pants {
    private int id;
    private String name;
    private Size size;
    private Material material;
    private Color color;
    private Fit fit;
    private Length length;
    private double price;

    private PropertyChangeSupport propertyChangeSupport;


    public Pants() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }



    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Size getSize() { return size; }
    public Material getMaterial() {
        return material;
    }
    public Color getColor() {
        return color;
    }
    public Length getLength() {
        return length;
    }
    public Fit getFit() { return fit; }
    public double getPrice() { return price; }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        Size oldSize = this.size;
        this.size = size;
        propertyChangeSupport.firePropertyChange("size", oldSize, this.size);
    }

    public void setMaterial(Material material) {
        Material oldMaterial = this.material;
        this.material = material;
        propertyChangeSupport.firePropertyChange("material", oldMaterial, this.material);
    }

    public void setColor(Color color) {
        Color oldColor = this.color;
        this.color = color;
        propertyChangeSupport.firePropertyChange("color", oldColor, this.color);
    }

    public void setFit(Fit fit) {
        Fit oldFit = this.fit;
        this.fit = fit;
        propertyChangeSupport.firePropertyChange("fit", oldFit, this.fit);
    }

    public void setLength(Length length) {
        Length oldLength = this.length;
        this.length = length;
        propertyChangeSupport.firePropertyChange("length", oldLength, this.length);
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
