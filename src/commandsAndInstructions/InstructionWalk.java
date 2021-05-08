package commandsAndInstructions;

import robs.Rob;
import simulation.World;

public class InstructionWalk extends Instruction {
    private static InstructionWalk INSTANCE = new InstructionWalk();

    private InstructionWalk() {};

    public static InstructionWalk getInstance() {
        return INSTANCE;
    }

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
