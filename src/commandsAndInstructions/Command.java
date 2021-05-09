package commandsAndInstructions;

import simulation.World;

public class Command {
    private final Commands command;
    private final Parameter parameter;
    private int priority;

    private void getPriority(Commands command) {
        switch(command) {
            case NR_ROUNDS -> priority = 0;
            case BOARD_SIZE_X -> priority = 1;
            case BOARD_SIZE_Y -> priority = 2;
            case BEGIN_ENERGY -> priority = 3;
            case BEGIN_NR_ROBS -> priority = 16;
            case BEGIN_PROGR -> priority = 15;
            case FOOD_QUALITY -> priority = 4;
            case FOOD_GROWTH -> priority = 5;
            case ROUND_COST -> priority = 6;
            case PROB_MULTIPLY -> priority = 7;
            case PART_OF_PARENT_ENERGY -> priority = 8;
            case MULTIPLY_LIMIT -> priority = 9;
            case PROB_REM_COMMAND -> priority = 10;
            case PROB_ADD_COMMAND -> priority = 11;
            case INSTRUCTIONS -> priority = 14;
            case PROB_CHANGE_COMMAND -> priority = 12;
            case OUTPUT_FREQ -> priority = 13;
        }
    }

    public Command(Commands command, Parameter parameter) {
        this.command = command;
        this.parameter = parameter;
        getPriority(command);
    }

    public void applyCommand(World world) {
        switch (command) {
            case NR_ROUNDS -> world.setNrRounds(parameter.getIntParam());
            case BOARD_SIZE_X -> world.getBoard().setNumberOfCols(parameter.getIntParam());
            case BOARD_SIZE_Y -> world.getBoard().setNumberOfRows(parameter.getIntParam());
            case BEGIN_ENERGY -> world.setBeginEnergy(parameter.getIntParam());
            case BEGIN_NR_ROBS -> world.createRobs(parameter.getIntParam());
            case BEGIN_PROGR -> world.setBaseProgram(parameter.getEnumParam());
            case FOOD_QUALITY -> world.getBoard().setFoodQuality(parameter.getIntParam());
            case FOOD_GROWTH -> world.getBoard().setFoodGrowth(parameter.getIntParam());
            case ROUND_COST -> world.setRoundCost(parameter.getIntParam());
            case PROB_MULTIPLY -> world.setProbMultiply(parameter.getDoubleParam());
            case PART_OF_PARENT_ENERGY -> world.setPartOfParentEnergy(parameter.getDoubleParam());
            case MULTIPLY_LIMIT -> world.setMultiplyLimit(parameter.getIntParam());
            case PROB_REM_COMMAND -> world.setProbRem(parameter.getDoubleParam());
            case PROB_ADD_COMMAND -> world.setProbAdd(parameter.getDoubleParam());
            case INSTRUCTIONS -> world.setInstructions(parameter.getEnumParam());
            case PROB_CHANGE_COMMAND -> world.setProbChangeCommand(parameter.getDoubleParam());
            case OUTPUT_FREQ -> world.setOutputFreq(parameter.getIntParam());
        }
    }

    public Commands getCommand() {
        return command;
    }

    public int getPriority() {
        return priority;
    }
}
