package commandsAndInstructions;

import board.Field;
import robs.Directions;
import robs.Rob;
import simulation.World;

public class InstructionWalk implements InstructionInterface {
    @Override
    public void applyCommand(Rob rob, World world) {
        switch(rob.getDirection()) {
            case UP -> rob.eatFood(
                    world.getBoard().getField(rob.getPosition().getRow() - 1, rob.getPosition().getCol()));
            case DOWN -> rob.eatFood(
                    world.getBoard().getField(rob.getPosition().getRow() + 1, rob.getPosition().getCol()));
            case LEFT -> rob.eatFood(
                    world.getBoard().getField(rob.getPosition().getRow(), rob.getPosition().getCol() - 1));
            case RIGHT -> rob.eatFood(
                    world.getBoard().getField(rob.getPosition().getRow(), rob.getPosition().getCol() + 1));
        }
    }
}
