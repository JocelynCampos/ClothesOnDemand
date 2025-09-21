package commands;

import enums.Pattern;
import interfaces.GarmentCommand;
import interfaces.SkirtOptions;
import models.Garments;

//For Skirt
public class PatternCommand implements GarmentCommand {
    private final Pattern pattern;

    public PatternCommand(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(Garments garment) {
        if (garment instanceof SkirtOptions skirtOptions) {
            skirtOptions.setPattern(pattern);
            garment.printAttribute("Pattern", pattern);
        }
    }
}
