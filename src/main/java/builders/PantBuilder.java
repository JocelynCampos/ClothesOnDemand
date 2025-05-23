package builders;

import enums.*;
import exception.InvalidGarmentException;
import interfaces.BaseGarmentInterface;
import interfaces.PantsOptions;
import models.Pants;

public class PantBuilder implements BaseGarmentInterface, PantsOptions {

    private Pants pants = new Pants();

    @Override
    public void setSize(Size size) {
        pants.setSize(size);
    }

    @Override
    public void setMaterial(Material material) {
        pants.setMaterial(material);
    }

    @Override
    public void setColor(Color color) {
        pants.setColor(color);
    }

    @Override
    public void setFit(Fit fit) {
        pants.setFit(fit);
    }

    @Override
    public void setLength(Length length) {
        pants.setLength(length);
    }

    public Pants getResult() {
        if (pants.getSize() == null || pants.getMaterial() == null || pants.getColor() == null
        || pants.getFit() == null || pants.getLength() == null) {
            throw new InvalidGarmentException("All garments must have attributes");
        }
        return pants;
    }

}
