package commands;

import enums.Neck;
import interfaces.GarmentCommand;
import interfaces.TshirtOptions;
import models.Garments;

//For T-Shirt
public class NeckCommand implements GarmentCommand {
    private final Neck neck;

    public NeckCommand(Neck neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Garments garments) {
        if (garments instanceof TshirtOptions tshirtOptions) {
            tshirtOptions.setNeck(neck);
            garments.printAttribute("Neck", neck);
        }
    }
}
