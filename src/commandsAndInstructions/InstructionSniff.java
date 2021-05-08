package commandsAndInstructions;

import board.Field;
import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionSniff implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        Directions direction = world.getBoard().findFoodCross(rob.getPosition());
        if (direction != null) {
            rob.setDirection(direction);
        }
    }
}
