package robs;

import board.Field;

public class Rob {
    private Field position;
    private int energy;
    private Directions direction;


    public Field getPosition() {
        return position;
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
