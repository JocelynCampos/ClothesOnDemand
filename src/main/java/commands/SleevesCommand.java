package commands;

import enums.Sleeves;
import interfaces.GarmentCommand;
import interfaces.TshirtOptions;
import models.Garments;

//For T-Shirt
public class SleevesCommand implements GarmentCommand {
    private final Sleeves sleeves;

    public SleevesCommand(Sleeves sleeves) {
        this.sleeves = sleeves;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof TshirtOptions tshirtOptions) {
            tshirtOptions.setSleeves(sleeves);
            garment.printAttribute("Sleeves", sleeves);
        }
    }
}
