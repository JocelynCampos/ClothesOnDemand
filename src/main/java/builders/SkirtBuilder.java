package builders;

import enums.*;
import exception.InvalidGarmentException;
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
        skirt.setWaistline(waistline);
    }

    @Override
    public void setPattern(Pattern pattern) {
        skirt.setPattern(pattern);
    }

    public Skirt getResult() {
        if (skirt.getSize() == null || skirt.getMaterial() == null || skirt.getColor() == null
        || skirt.getWaistline() == null || skirt.getPattern() == null) {
            throw new InvalidGarmentException("All garments must have attributes");
        }
        return skirt;
    }
}
