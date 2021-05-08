package commandsAndInstructions;

import board.Field;
import robs.Rob;
import simulation.World;

public class InstructionEat implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        Field p = world.getBoard().findFood(rob.getPosition());
        if (p.getRow() != -1) {
            rob.eatFood(p);
            rob.setPosition(p);
        }
    }
}
