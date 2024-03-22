package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


public class CrapsGame implements GameInterface {
    private static final IOConsole console = new IOConsole(AnsiColor.CYAN);
    public static int comeOutRoll;
    public static int repeatDiceRoll;
    public static double playerBet;
    public static boolean playerWins = false;
    public static boolean playerLoses = false;
    public static double userBalance = 500;

    public static void gameStart() {    // temporary

        playerWins = false;
        playerLoses = false;

        gameRules();
        comeOutRoll();
        pointRoll();

        winningRoll();
        losingRoll();

    }

    public static void gameRules() {
        console.println(
                "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                        "|                                  [Craps Rules]                                                    |\n" +
                        "| - An even money bet, made on the first roll of the dice (known as the “come out roll”).           |\n" +
                        "| - You win if a 7 or 11 roll, or lose if 2, 3, or 12 roll (known as “craps”).                      |\n" +
                        "| - Any other number that rolls becomes the “point” and the point must roll again before a 7 to win.|\n" +
                        "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
    }

    public static int comeOutRoll() {

        console.println("[Your current balance: " + CrapsPlayer.playerBalance + "]");
        playerBet = console.getIntegerInput("Place your bet on the Pass Line: [Minimum Bet $10]"); //this will be through wager method.

        if (playerBet >= 10) {      // if player wager is greater than or equal to 10 continue the game
            CrapsPlayer.userInputRoll();
            diceImage();

            comeOutRoll = CrapsPlayer.diceRoll();
            int diceOne = CrapsPlayer.dieOne;
            int diceTwo = CrapsPlayer.dieTwo;
            console.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");
            console.println("You rolled a {" + comeOutRoll + "}\n");
        }
        if (playerBet < 10) {
            console.println("You can't wager less then $10.");
            comeOutRoll();
        }
        return 0;
    }

    public static boolean winningRoll() {
        if (comeOutRoll == 7 || comeOutRoll == 11 || comeOutRoll == repeatDiceRoll) {
            CrapsPlayer.payOut = playerBet * 2;
            CrapsPlayer.playerBalance += CrapsPlayer.payOut;
            console.println("You won! Your bet: [" + playerBet + "] Your winnings: [" + CrapsPlayer.payOut + "]!");
            return playerWins = true;
        }
        return false;
    }

    public static boolean losingRoll() {
        if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12 || repeatDiceRoll == 7 && comeOutRoll != 7) {
            CrapsPlayer.payOut -= playerBet;
            CrapsPlayer.playerBalance += CrapsPlayer.payOut;
            console.println("You lost! [You lost: " + CrapsPlayer.payOut + "]");
            return playerLoses = true;
        }
        return false;
    }

    public static void pointRoll() {
        if (comeOutRoll == 4 || comeOutRoll == 5 || comeOutRoll == 6 || comeOutRoll == 8 || comeOutRoll == 9 || comeOutRoll == 10) {
            console.println("You rolled a point number!");

            CrapsPlayer.secondaryWagerOption();
            CrapsPlayer.secondaryWager();

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
            (An additional bet that user will roll the point number again)
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

    public static void diceImage() {
        System.out.println(
                "               (( _______\n" +
                        "     _______     /\\O    O\\\n" +
                        "    /O     /\\   /  \\      \\\n" +
                        "   /  O   /O \\ / O  \\O____O\\ ))\n" +
                        "((/_____O/    \\\\    /O     /\n" +
                        "  \\O    O\\    / \\  /   O  /\n" +
                        "   \\O    O\\ O/   \\/_____O/\n" +
                        "    \\O____O\\/ ))          ))\n" +
                        "  ((\n");
    }

    public static void pointRollDice() {
        int pointDiceRoll = CrapsPlayer.diceRoll();
        while (pointDiceRoll != comeOutRoll || pointDiceRoll != 7 || pointDiceRoll != CrapsPlayer.pointNumber) {

            CrapsPlayer.userInputRoll();
            diceImage();

            repeatDiceRoll = CrapsPlayer.diceRoll();
            int diceOne = CrapsPlayer.dieOne;
            int diceTwo = CrapsPlayer.dieTwo;
            console.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");

            if (repeatDiceRoll == comeOutRoll) {
                CrapsPlayer.payOut += playerBet + playerBet;
                CrapsPlayer.playerBalance += CrapsPlayer.payOut;
                console.println("Your first Bet: " + playerBet + " Your winnings: " + CrapsPlayer.playerBalance);
                break;
            } else if (repeatDiceRoll == 7) {
                CrapsPlayer.payOut += playerBet;
                CrapsPlayer.playerBalance -= CrapsPlayer.payOut;
                console.println("You rolled a {" + repeatDiceRoll + "}\n You lost! [You lost: " + CrapsPlayer.payOut + "]");
                break;
            } else if (repeatDiceRoll != 7 || repeatDiceRoll != comeOutRoll) {

                console.println(
                        "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                                "You rolled a {" + repeatDiceRoll + "} which is not {" + comeOutRoll + "} or 7, Roll again." +
                                "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void run() {
        do {
            gameStart();
            String playAgain = console.getStringInput("Would you like to play again? (yes/no)");
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);
    }


    @Override
    public boolean getWinner() {
        return false;
    }
}
