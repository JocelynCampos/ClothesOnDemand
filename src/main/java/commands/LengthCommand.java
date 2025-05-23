package commands;

import enums.Fit;
import enums.Length;
import interfaces.PantsOptions;
import models.Garments;

//For Pants
public class LengthCommand {
    private final Length length;
    public LengthCommand(Length length) {
        this.length = length;
    }
    public void execute(Garments garments) {
        if (garments instanceof PantsOptions pantsOptions) {
            pantsOptions.setLength(length);
            garments.printAttribute("Length", length);
        }
    }
}
