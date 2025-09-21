package builders;

import enums.*;
import exception.InvalidGarmentException;
import interfaces.BaseGarmentInterface;
import models.TShirt;

public class TShirtBuilder implements BaseGarmentInterface<TShirtBuilder> {

    private final TShirt tShirt = new TShirt();

    @Override
    public TShirtBuilder setSize(Size size) {
        tShirt.setSize(size);
        return this;
    }

    @Override
    public TShirtBuilder setMaterial(Material material) {
        tShirt.setMaterial(material);
        return this;
    }

    @Override
    public TShirtBuilder setColor(Color color) {
        tShirt.setColor(color);
        return this;
    }


    public TShirt getResult() {
        if (tShirt.getSize() == null || tShirt.getMaterial() == null || tShirt.getColor() == null)
            throw new InvalidGarmentException("All garments must have attributes");
        return tShirt;
    }
}
