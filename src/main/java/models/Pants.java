package models;
import enums.*;

public class Pants extends Garments {
    private Fit fit;
    private Length length;
    private double price;

    public Pants() {
        super("Pants");
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
