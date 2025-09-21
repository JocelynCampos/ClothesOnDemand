package interfaces;

import enums.*;

public interface BaseGarmentInterface<T extends BaseGarmentInterface<T>> {

    //Shared attributes
    T setSize(Size size);
    T setMaterial(Material material);
    T setColor(Color color);
}
