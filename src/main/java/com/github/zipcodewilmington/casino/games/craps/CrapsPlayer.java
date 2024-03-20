package com.github.zipcodewilmington.casino.games.craps;

import java.util.Random;
import java.util.Scanner;

public class CrapsPlayer {

    public static Random rand = new Random();
    public static Scanner scan = new Scanner(System.in);
    public static int dieOne;
    public static int dieTwo;
    public static int currentRoll;
    public static String rollsDiceOption;

    public static int diceRoll(){
        dieOne = rand.nextInt(7 - 1) +1;
        dieTwo = rand.nextInt(7 - 1) +1;
        return currentRoll = dieOne + dieTwo;
    }

    public static String userRoll() {
        return rollsDiceOption = scan.next();
    }
}
