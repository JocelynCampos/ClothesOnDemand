package builders;

import enums.*;
import exception.InvalidGarmentException;
import interfaces.BaseGarmentInterface;
import interfaces.TshirtOptions;
import models.TShirt;

public class TshirtBuilder implements BaseGarmentInterface, TshirtOptions {

    TShirt tShirt = new TShirt();

    @Override
    public void setSize(Size size) {
        tShirt.setSize(size);
    }

    @Override
    public void setMaterial(Material material) {
        tShirt.setMaterial(material);
    }

    @Override
    public void setColor(Color color) {
        tShirt.setColor(color);
    }

    @Override
    public void setSleeves(Sleeves sleeves) {
        tShirt.setSleeves(sleeves);
    }

    @Override
    public void setNeck(Neck neck) {
        tShirt.setNeck(neck);
    }

    public TShirt getResult() {
        if (tShirt.getSize() == null || tShirt.getMaterial() == null || tShirt.getColor() == null
        || tShirt.getNeck() == null || tShirt.getSleeves() == null)
            throw new InvalidGarmentException("All garments must have attributes");
        return tShirt;
    }
}
