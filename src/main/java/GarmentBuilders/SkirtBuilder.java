package GarmentBuilders;

import enums.Pattern;
import enums.Waistline;
import models.Skirt;

public class SkirtBuilder extends GarmentBuilder {
    private Waistline waistline;
    private Pattern pattern;

    public  SkirtBuilder setWaistline(Waistline waistline) {
        this.waistline = waistline;
        return this;
    }

    public SkirtBuilder setPattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }

    @Override
    public Skirt build() {
        Skirt skirt = new Skirt();

        skirt.setSize(size);
        skirt.setMaterial(material);
        skirt.setColor(color);
        skirt.setWaistline(waistline);
        skirt.setPattern(pattern);
        return skirt;
    }
}
