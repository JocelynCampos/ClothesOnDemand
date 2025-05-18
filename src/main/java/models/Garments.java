package models;
import enums.Color;
import enums.Material;
import enums.Size;

public abstract class Garments {

    private static int idCounter = 1;
    private int id;
    private String name;
    protected Size size;
    protected Material material;
    protected Color color;

    public Garments(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColor() {
        return color;
    }
    public void setColor (Color color) {
        this.color = color;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Garments.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaterial(Material material) { this.material = material; }

}
