package commands;

import enums.Length;
import interfaces.GarmentCommand;
import interfaces.PantsOptions;
import models.Garments;

//For Pants
public class LengthCommand implements GarmentCommand {
    private final Length length;

    public LengthCommand(Length length) {
        this.length = length;
    }
    @Override
    public void execute(Garments garment) {

        if (garment instanceof PantsOptions pantsOptions) {
            pantsOptions.setLength(length);
            garment.printAttribute("Length", length);
        }
    }
}
