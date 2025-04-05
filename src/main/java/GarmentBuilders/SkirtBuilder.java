package GarmentBuilders;

import enums.*;
import interfaces.BaseGarmentInterface;
import interfaces.SkirtOptions;
import models.Skirt;

public class SkirtBuilder implements BaseGarmentInterface, SkirtOptions {

    Skirt skirt = new Skirt();

    @Override
    public void setSize(Size size) {
        skirt.setSize(size);
    }

    @Override
    public void setMaterial(Material material) {
        skirt.setMaterial(material);
    }

    @Override
    public void setColor(Color color) {
        skirt.setColor(color);
    }

    @Override
    public void setWaistline(Waistline waistline) {

    }

    @Override
    public void setPattern(Pattern pattern) {

    }
}
