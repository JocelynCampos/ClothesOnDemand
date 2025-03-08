package GarnmentBuilders;

import enums.Color;
import enums.Material;
import enums.Size;
import models.Garnments;

public abstract class GarnmentBuilder {
    protected Size size;
    protected Material material;
    protected Color color;

    //TODO validate Size
    public GarnmentBuilder addSize (Size size) {
        this.size = size;
        return this;
    }

    //TODO validate Material
    public GarnmentBuilder addMaterial (Material material) {
        this.material = material;
        return this;
    }

    //TODO validate Color
    public GarnmentBuilder addColor (Color color) {
        this.color = (color);
        return this;
    }

    public abstract Garnments build();
}
