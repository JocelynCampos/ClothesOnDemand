package commands;

import enums.Fit;
import interfaces.GarmentCommand;
import interfaces.PantsOptions;
import models.Garments;

//For Pants
public class FitCommand implements GarmentCommand {
    private final Fit fit;

    public FitCommand(Fit fit) {
        this.fit = fit;
    }

    @Override
    public void execute(Garments garments) {
        if (garments instanceof PantsOptions pantsOptions) {
            pantsOptions.setFit(fit);
            garments.printAttribute("Fit", fit);
        }

    }
}
