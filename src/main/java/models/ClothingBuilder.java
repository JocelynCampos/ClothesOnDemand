package models;
import enums.Color;
import enums.Material;
import enums.Size;

public abstract class ClothingBuilder {
    private Pants pants = new Pants();
    private TShirt tShirt = new TShirt();
    private Skirt skirt = new Skirt();

    public ClothingBuilder addSize(Object clothing, String size) {
        //TODO validate Size
        if (clothing instanceof Pants) {
            ((Pants) clothing).setSize(Size.valueOf(size));
        } else if (clothing instanceof TShirt) {
            ((TShirt) clothing).setSize(Size.valueOf(size));
        } else if (clothing instanceof Skirt) {
            ((Skirt) clothing).setSize(Size.valueOf(size));
        }
        return this;
    }

    public ClothingBuilder addMaterial(Object clothing, String material) {
        //TODO validate Material
        if (clothing instanceof Pants) {
            ((Pants) clothing).setMaterial(Material.valueOf(material));
        } else if (clothing instanceof TShirt) {
            ((TShirt) clothing).setMaterial(Material.valueOf(material));
        } else if (clothing instanceof Skirt) {
            ((Skirt) clothing).setMaterial(Material.valueOf(material));
        }
        return this;
    }

    public ClothingBuilder addColor(Object clothing, String color) {
        //TODO validate Color
        if (clothing instanceof Pants) {
            ((Pants) clothing).setColor(Color.valueOf(color));
        } else if (clothing instanceof TShirt) {
            ((TShirt) clothing).setColor(Color.valueOf(color));
        } else if (clothing instanceof Skirt) {
            ((Skirt) clothing).setColor(Color.valueOf(color));
        }
        return this;
    }
}
