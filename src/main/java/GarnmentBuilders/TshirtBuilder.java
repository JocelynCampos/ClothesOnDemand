package GarnmentBuilders;

import enums.Neck;
import enums.Sleeves;
import models.TShirt;

public class TshirtBuilder extends GarnmentBuilder {
    private Sleeves sleeves;
    private Neck neck;

    public TshirtBuilder setSleeves(Sleeves sleeves) {
        this.sleeves = sleeves;
        return this;
    }

    public TshirtBuilder setNeck(Neck neck) {
        this.neck = neck;
        return this;
    }

    @Override
    public TShirt build() {
        TShirt tShirt = new TShirt();

        tShirt.setSize(size);
        tShirt.setMaterial(material);
        tShirt.setColor(color);
        tShirt.setSleeves(sleeves);
        tShirt.setNeck(neck);
        return tShirt;
    }
}
