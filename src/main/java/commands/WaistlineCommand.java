package commands;

import enums.Waistline;
import interfaces.GarmentCommand;
import interfaces.SkirtOptions;
import models.Garments;

//For Skirt
public class WaistlineCommand implements GarmentCommand {

    private final Waistline waistline;
    public WaistlineCommand(Waistline waistline) {
        this.waistline = waistline;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof SkirtOptions skirtOptions) {
            skirtOptions.setWaistline(waistline);
            garment.printAttribute("Waistline", waistline);
        }
    }
}
