package commands;

import interfaces.GarmentCommand;
import models.Garments;

import java.util.ArrayList;
import java.util.List;

public class GarmentCommandPipeline {
    private final List<GarmentCommand> commands = new ArrayList<>();


    public GarmentCommandPipeline addCommand(GarmentCommand command) {
        commands.add(command);
        return this;
    }

    public Garments executeAll(Garments garment) {
        for (GarmentCommand command : commands) {
            command.execute(garment);
        }
        return garment;
    }

    public void clear() {
        commands.clear();
    }

}
