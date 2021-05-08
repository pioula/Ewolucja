package commandsAndInstructions;

import board.Field;
import robs.Rob;
import simulation.World;

public class InstructionEat implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        Field p = world.getBoard().findFood(rob.getPosition());
        if (p.getRow() != -1) {
            p.eatFood(world.getBoard().getFoodGrowth());
            rob.setEnergy(rob.getEnergy() + world.getBoard().getFoodQuality());
            rob.setPosition(p);
        }
    }
}
