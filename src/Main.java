import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import input.*;
import simulation.World;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        World world = input.readInput(args[0], args[1]);
        //world.simulation();
    }
}
