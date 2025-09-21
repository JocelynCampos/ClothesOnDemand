package builders;

import enums.*;
import exception.InvalidGarmentException;
import interfaces.BaseGarmentInterface;
import models.Skirt;

public class SkirtBuilder implements BaseGarmentInterface<SkirtBuilder> {

    private final Skirt skirt = new Skirt();

    @Override
    public SkirtBuilder setSize(Size size) {
        skirt.setSize(size);
        return this;
    }

    @Override
    public SkirtBuilder setMaterial(Material material) {
        skirt.setMaterial(material);
        return this;
    }

    @Override
    public SkirtBuilder setColor(Color color) {
        skirt.setColor(color);
        return this;
    }


    public Skirt getResult() {
        if (skirt.getSize() == null || skirt.getMaterial() == null || skirt.getColor() == null) {
            throw new InvalidGarmentException("All garments must have attributes");
        }
        return skirt;
    }
}
