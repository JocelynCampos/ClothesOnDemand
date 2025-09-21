package models;

import enums.*;

public class TShirt extends Garments {
    private Sleeves sleeves;
    private Neck neck;

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

    @Override
    public String toString() {
        return super.toString();
    }
}