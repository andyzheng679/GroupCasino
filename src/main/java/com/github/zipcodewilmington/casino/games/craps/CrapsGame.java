package com.github.zipcodewilmington.casino.games.craps;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.games.craps.CrapsPlayer.rollsDiceOption;

public class CrapsGame {
    public static Scanner scan = new Scanner(System.in);
    public static int comeOutRoll;

    public static void main(String[] args) {

        gameRules();
        comeOutRoll();

        winningRoll();
        losingRoll();
        pointRoll();

    }

    public static void gameRules() {
        System.out.println(
                "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                "                                   [Craps Rules]\n" +
                "   - An even money bet, made on the first roll of the dice (known as the “come out roll”).\n" +
                "   - You win if a 7 or 11 roll, or lose if 2, 3, or 12 roll (known as “craps”).\n" +
                "   - Any other number that rolls becomes the “point” and the point must roll again before a 7 to win.\n" +
                "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
    }

    public static void comeOutRoll() {
        System.out.println("Place your bet on the Pass Line: ");
        int playerBet = scan.nextInt();
        if (playerBet >= 10) {
            System.out.println(
                    "\n-----------------------\n" +
                    "Please Roll the dice:\n[roll]");
            CrapsPlayer.userRoll();
            System.out.println(
                    "-----------------------\n");
            diceImage();
        }
        comeOutRoll = CrapsPlayer.diceRoll();
        System.out.println("You rolled a " + comeOutRoll + "\n");
    }

    public static boolean winningRoll() {
        if (comeOutRoll == 7 || comeOutRoll == 11) {
            System.out.println("You win!\n");
            return true;
        }
        return false;
    }

    public static boolean losingRoll() {
        if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
            System.out.println("You lose!\n");
            return true;
        }
        return false;
    }

    public static void pointRoll() {
        if (comeOutRoll == 4 || comeOutRoll == 5 || comeOutRoll == 6 || comeOutRoll == 8 || comeOutRoll == 9 || comeOutRoll == 10) {
            System.out.println("You rolled a point number, Roll again.");
            int pointDiceRoll = CrapsPlayer.diceRoll();
            while (pointDiceRoll != comeOutRoll || pointDiceRoll != 7) {

                System.out.println(
                        "\n-----------------------\n" +
                        "Please Roll the dice:\n[roll]");
                CrapsPlayer.userRoll();
                System.out.println(
                        "-----------------------\n");
                diceImage();

                int repeatDiceRoll = CrapsPlayer.diceRoll();

                if (repeatDiceRoll == comeOutRoll) {
                    System.out.println("\nYou rolled a " + repeatDiceRoll);
                    break;
                } else if (repeatDiceRoll == 7){
                    System.out.println("\nYou rolled a " + repeatDiceRoll);
                    break;
                }

                System.out.println(
                        "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                        "You rolled a " + repeatDiceRoll + " which is not " + comeOutRoll + " or 7, Roll again." +
                        "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            }
        }
    }
            /*
            if (ask for user input if they would like to bet again){
                while (currentRoll != 7 || currentRoll != pointNumber || currentRoll != placeBet()){
                    continues loop until conditions are met.
                }
            }
            */

            // tell user puck is on point
            // if user rolls 7 here they lose
            /*
            you can set a pass line odds bet:
            ----------------------------------
            (An additional bet that user will role the point number again)
            4 & 10 pays 2:1 (x2)
            5 & 9 pays 3:2  (x2.5) return (1.5)
            6 & 8 pays 6:5  (x2.2) return (1.2)
            */
       // }
    //}
    /*
    place bet: A specific number rolls before a 7
    ---------------------------------------------
    4 & 10 pays 2:1 (x2)
    5 & 9 pays 3:2  (x2.5) return (1.5)
    6 & 8 pays 6:5  (x2.2) return (1.2)
    */
    public static void endGameOption() {

    }

    public static void gameStart() {

    }

    public static void diceImage() {
        System.out.println(
                "               (( _______\n" +
                        "     _______     /\\O    O\\\n" +
                        "    /O     /\\   /  \\      \\\n" +
                        "   /   O  /O \\ / O  \\O____O\\ ))\n" +
                        "((/_____O/    \\\\    /O     /\n" +
                        "  \\O    O\\    / \\  /   O  /\n" +
                        "   \\O    O\\ O/   \\/_____O/\n" +
                        "    \\O____O\\/ ))          ))\n" +
                        "  ((\n");
    }

}
