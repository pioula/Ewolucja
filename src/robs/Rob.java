package robs;

import board.Field;
import commandsAndInstructions.Instruction;

import java.util.ArrayList;
import java.util.Random;

public class Rob {
    private Field position;
    private int energy, age;
    private Directions direction;
    private ArrayList<Instruction> program;

    public Rob(Field position, int energy, ArrayList<Instruction> program) {
        this.position = position;
        this.energy = energy;
        this.program = program;
        this.age = 0;
    }

    public void raiseAge() {
        age++;
    }

    public int getAge() {
        return age;
    }

    public boolean eatFood(Field field) {
        if (field.isThereFood()) {
            energy += field.getFoodQuality();
            field.clearFood();
            return true;
        }

        return false;
    }

    public Rob multiplyRob(double probAdd, double probRem, double probChange,
                           double partOfParentEnergy, ArrayList <Instruction> Instructions) {
        Random r = new Random();
        ArrayList<Instruction> newProgram = new ArrayList<Instruction>();

        int removedIndex = Probability.isHappened(probRem) ? r.nextInt(program.size()) : -1;
        for (int i = 0; i < program.size(); i++) {
            if (i != removedIndex)
                newProgram.add(program.get(i));
        }

        if (Probability.isHappened(probAdd))
            newProgram.add(Instructions.get(r.nextInt(Instructions.size())));

        if (Probability.isHappened(probChange))
            newProgram.set(r.nextInt(newProgram.size()),
                    Instructions.get(r.nextInt(Instructions.size())));

        int newEnergy = (int)(energy * partOfParentEnergy);
        energy -= newEnergy;
        return new Rob(position, newEnergy, newProgram);
    }

    public void useEnergyForInstruction() {
        energy--;
    }

    public Field getPosition() {
        return position;
    }

    public ArrayList<Instruction> getProgram() {
        return program;
    }

    public int getEnergy() {
        return energy;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setPosition(Field position) {
        this.position = position;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


}
