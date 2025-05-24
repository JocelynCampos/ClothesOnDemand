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
    public void execute(Garments garments) {
        if (garments instanceof SkirtOptions skirtOptions) {
            skirtOptions.setPattern(pattern);
            garments.printAttribute("Pattern", pattern);
        }
    }
}
