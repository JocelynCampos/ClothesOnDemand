package commands;

import enums.Fit;
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
    public void execute(Garments garments) {
        if (garments instanceof PantsOptions pantsOptions) {
            pantsOptions.setLength(length);
            garments.printAttribute("Length", length);
        }
    }
}
