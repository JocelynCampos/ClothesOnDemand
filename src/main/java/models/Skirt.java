package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import enums.*;

public class Skirt {
    private int id;
    private String name;
    private Size size;
    private Material material;
    private Color color;
    private Waistline waistline;
    private Pattern pattern;
    private double price;

    private PropertyChangeSupport propertyChangeSupport;

    public Skirt() {
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

    public Waistline getWaistline() {
        return waistline;
    }

    public void setWaistline(Waistline waistline) {
        Waistline oldWaistline = this.waistline;
        this.waistline = waistline;
        propertyChangeSupport.firePropertyChange("material", oldWaistline, this.waistline);
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        Pattern oldPattern = this.pattern;
        this.pattern = pattern;
        propertyChangeSupport.firePropertyChange("pattern", oldPattern, this.pattern);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
