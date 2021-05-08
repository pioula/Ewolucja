package commandsAndInstructions;

import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionRight implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        rob.setDirection(Directions.RIGHT);
    }
}
