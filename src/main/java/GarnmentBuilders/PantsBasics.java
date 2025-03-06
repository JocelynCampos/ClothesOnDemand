package GarnmentBuilders;

import enums.Color;
import enums.Material;
import enums.Size;
import models.Pants;

public abstract class PantsBasics {
    Pants pants = new Pants();

    //TODO validate Color
    public PantsBasics addColor (Color color) {
        pants.setColor(color);

    }

    //TODO validate Size
    public PantsBasics addSize (Size size) {
        pants.setSize(size);

    }

    //TODO validate Material
    public PantsBasics addMaterial (Material material) {
        pants.setMaterial(material);

    }
}
