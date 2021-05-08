package simulation;

import board.Board;
import board.Field;
import commandsAndInstructions.*;
import robs.Probability;
import robs.Rob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class World {
    private static final int numberOfCommands = 14;
    private int nrRounds, roundCost, multiplyLimit, outputFreq, beginEnergy;
    private double probMultiply, partOfParentEnergy, probRem, probAdd, probChangeCommand;
    private final Board board;
    private final ArrayList<Command> commands;
    private ArrayList<Instruction> baseProgram, instructions;
    private ArrayList<Rob> robs;

    private static boolean areCommandsCorrect(ArrayList<Command> commands) {
        commands.sort(Comparator.comparing(o -> o.getCommand().toString()));

        int commandsSize = commands.size();
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getCommand() == Commands.BOARD_SIZE_X ||
                commands.get(i).getCommand() == Commands.BOARD_SIZE_Y) {
                commandsSize--;
            }
            else if (i + 1 < commands.size() &&
                    commands.get(i).getCommand() == commands.get(i+1).getCommand()) {
                return false;
            }
        }

        return commandsSize == numberOfCommands;
    }

    public World(Board board, ArrayList<Command> commands) {
        assert areCommandsCorrect(commands) : "ERROR WRONG COMMANDS!";
        this.board = board;
        this.commands = commands;
    }

    public void createRobs(int numberOfRobs) {
        Random r = new Random();
        for (int i = 0; i < numberOfRobs; i++) {
            Field f = board.getField(r.nextInt(board.getNumberOfRows()), r.nextInt(board.getNumberOfCols()));
            robs.add(new Rob(f, beginEnergy, baseProgram));
        }
    }

    public void simulation() {
        Random r = new Random();
        for (int i = 0; i < nrRounds; i++) {
            Collections.shuffle(robs);
            ArrayList<Rob> newRobs = new ArrayList<Rob>();

            for(Rob rob : robs) {
                for (Instruction instruction : rob.getProgram()) {
                    if (rob.getEnergy() <= 0)
                        break;
                    instruction.applyInstruction(rob, this);
                }

                if (rob.getEnergy() > 0) {
                    if (rob.getEnergy() >= multiplyLimit && Probability.isHappened(probMultiply)) {
                        Rob child = rob.multiplyRob(probAdd, probRem, probChangeCommand,
                                partOfParentEnergy, instructions);
                        newRobs.add(child);
                    }
                    newRobs.add(rob);
                }
            }

            board.nextRound();
            robs = newRobs;
        }
    }

    public void setBeginEnergy(int beginEnergy) {
        this.beginEnergy = beginEnergy;
    }

    public void setNrRounds(int nrRounds) {
        this.nrRounds = nrRounds;
    }

    public void setBaseProgram(ArrayList<Instruction> baseProgram) {
        this.baseProgram = baseProgram;
    }

    public void setRoundCost(int roundCost) {
        this.roundCost = roundCost;
    }

    public void setProbMultiply(double probMultiply) {
        this.probMultiply = probMultiply;
    }

    public void setPartOfParentEnergy(double partOfParentEnergy) {
        this.partOfParentEnergy = partOfParentEnergy;
    }

    public void setMultiplyLimit(int multiplyLimit) {
        this.multiplyLimit = multiplyLimit;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void setOutputFreq(int outputFreq) {
        this.outputFreq = outputFreq;
    }

    public void setProbAdd(double probAdd) {
        this.probAdd = probAdd;
    }

    public void setProbRem(double probRem) {
        this.probRem = probRem;
    }

    public void setProbChangeCommand(double probChangeCommand) {
        this.probChangeCommand = probChangeCommand;
    }

    public Board getBoard() {
        return board;
    }
}
