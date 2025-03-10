package GarmentBuilders;

import enums.Color;
import enums.Material;
import enums.Size;
import models.Garments;

public abstract class GarmentBuilder {
    protected Size size;
    protected Material material;
    protected Color color;

    //TODO validate Size
    public GarmentBuilder addSize (Size size) {
        this.size = size;
        return this;
    }

    //TODO validate Material
    public GarmentBuilder addMaterial (Material material) {
        this.material = material;
        return this;
    }

    //TODO validate Color
    public GarmentBuilder addColor (Color color) {
        this.color = (color);
        return this;
    }

    public abstract Garments build();
}
