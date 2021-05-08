package commandsAndInstructions;

import java.util.ArrayList;

public class Parameter {
    private double doubleParam;
    private int intParam;
    private ArrayList<Instructions> enumParam;

    public Parameter(double param) {
        doubleParam = param;
    }

    public Parameter(int param) {
        intParam = param;
    }

    public Parameter(ArrayList<Instructions> param) {
        enumParam = param;
    }

    public double getDoubleParam() {
        return doubleParam;
    }

    public int getIntParam() {
        return intParam;
    }

    public ArrayList<Instructions> getEnumParam() {
        return enumParam;
    }
}
