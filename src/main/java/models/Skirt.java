package models;
import enums.*;

public class Skirt extends Garnments {
    private Waistline waistline;
    private Pattern pattern;
    private double price;


    public Skirt() {
        super("Skirt");
    }

    public Waistline getWaistline() {
        return waistline;
    }

    public void setWaistline(Waistline waistline) {
        this.waistline = waistline;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}