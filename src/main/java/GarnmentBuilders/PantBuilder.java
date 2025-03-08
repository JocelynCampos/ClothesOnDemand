package GarnmentBuilders;

import enums.Fit;
import enums.Length;
import models.Garnments;
import models.Pants;

public class PantBuilder extends GarnmentBuilder {
    private Fit fit;
    private Length length;

    public PantBuilder setFit(Fit fit) {
        this.fit = fit;
        return this;
    }

    public PantBuilder setLength(Length length) {
        this.length = length;
        return this;
    }

    @Override
    public Pants build() {
        Pants pants = new Pants();
        pants.setSize(size);
        pants.setMaterial(material);
        pants.setColor(color);
        pants.setFit(fit);
        pants.setLength(length);
        return pants;
    }
}
