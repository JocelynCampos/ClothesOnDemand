package builders;

import enums.*;
import exception.InvalidGarmentException;
import interfaces.BaseGarmentInterface;
import models.Pants;

public class PantBuilder implements BaseGarmentInterface<PantBuilder> {

    private final Pants pants = new Pants();

    @Override
    public PantBuilder setSize(Size size) {
        pants.setSize(size);
        return this;
    }

    @Override
    public PantBuilder setMaterial(Material material) {
        pants.setMaterial(material);
        return this;
    }

    @Override
    public PantBuilder setColor(Color color) {
        pants.setColor(color);
        return this;
    }


    public Pants getResult() {
        if (pants.getSize() == null || pants.getMaterial() == null || pants.getColor() == null) {
            throw new InvalidGarmentException("All garments must have attributes");
        }
        return pants;
    }

}
