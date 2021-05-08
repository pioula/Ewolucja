package commandsAndInstructions;

import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionLeft implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        rob.setDirection(Directions.LEFT);
    }
}
