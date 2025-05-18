package models;

import enums.*;

public class TShirt extends Garments {
    private Sleeves sleeves;
    private Neck neck;
    private double price;

    public TShirt() {
        super("T-Shirt");
    }

    public Sleeves getSleeves() {
        return sleeves;
    }

    public void setSleeves(Sleeves sleeves) {
        this.sleeves = sleeves;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

}