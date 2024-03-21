package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

public class CrapsPlayer {

    public static Random rand = new Random();
    private static final IOConsole console = new IOConsole(AnsiColor.CYAN);
    public static int dieOne;
    public static int dieTwo;
    public static int currentRoll;
    public static String rollsDiceOption;
    public static String secondaryWager;
    public static double playerPointBet;
    public static double playerPassLineBet;
    public static int pointNumber;
    public static double playerBalance = CrapsGame.userBalance;
    public static double openingBet = CrapsGame.playerBet;


    public static int diceRoll() {
        dieOne = rand.nextInt(7 - 1) + 1;
        dieTwo = rand.nextInt(7 - 1) + 1;
        return currentRoll = dieOne + dieTwo;
    }

    public static void userInputRoll() {
        rollsDiceOption = console.getStringInput( "\n-<>-<>-<>-<>-<>-<>-<>-<>-\n" +
                "Please Roll the dice:\n[roll]");
        System.out.println("-<>-<>-<>-<>-<>-<>-<>-<>-\n");
    }

    public static String secondaryWagerOption() {
        return secondaryWager = console.getStringInput("Would you like to add another wager?\n [ PASS-LINE ] [ POINT ] [NO-WAGER]");
    }

    public static double secondaryWager() {
        switch (secondaryWager) {
            case "PASS-LINE":
                playerPassLineBet = console.getDoubleInput("How much would you like to wager?");
                int pointDiceRoll = CrapsPlayer.diceRoll();
                while (pointDiceRoll != CrapsGame.comeOutRoll || pointDiceRoll != 7 || pointDiceRoll != CrapsPlayer.pointNumber) {

                    CrapsPlayer.userInputRoll();
                    CrapsGame.diceImage();

                    int repeatDiceRoll = CrapsPlayer.diceRoll();
                    int diceOne = CrapsPlayer.dieOne;
                    int diceTwo = CrapsPlayer.dieTwo;
                    System.out.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");
                    System.out.println("You rolled a " + repeatDiceRoll);

                    if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 4 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 10) {
                        playerBalance += (playerPassLineBet * 2) +openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPassLineBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 4 or 10

                    } else if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 5 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 9) {
                        playerBalance += (playerPassLineBet * 1.5) + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPassLineBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 5 or 9

                    } else if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 6 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 8) {
                        playerBalance += (playerPassLineBet * 1.2) + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPassLineBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 6 or 8

                    } else if (repeatDiceRoll == CrapsGame.comeOutRoll) {
                        playerBalance += openingBet + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();

                    } else if (repeatDiceRoll == 7) {
                        CrapsGame.losingRoll();
                        CrapsGame.gameStart();
                    }
                }

            case "POINT":
                playerPointBet = console.getDoubleInput("How much would you like to wager?");
                pointNumber = console.getIntegerInput("What point number would you like to place your wager on?");
                int DiceRoll = CrapsPlayer.diceRoll();
                while (DiceRoll != CrapsGame.comeOutRoll || DiceRoll != 7 || DiceRoll != CrapsPlayer.pointNumber) {

                    CrapsPlayer.userInputRoll();
                    CrapsGame.diceImage();

                    int repeatDiceRoll = CrapsPlayer.diceRoll();
                    int diceOne = CrapsPlayer.dieOne;
                    int diceTwo = CrapsPlayer.dieTwo;
                    System.out.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");
                    System.out.println("You rolled a {" + repeatDiceRoll + "}\n");

                    if (pointNumber == repeatDiceRoll && pointNumber == 4 || pointNumber == repeatDiceRoll && pointNumber == 10) {
                        playerBalance += (playerPointBet * 2) + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPointBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 4 or 10
                    } else if (pointNumber == repeatDiceRoll && pointNumber == 5 || pointNumber == repeatDiceRoll && pointNumber == 9) {
                        playerBalance += (playerPointBet * 1.5) + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPointBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 5 or 9
                    } else if (pointNumber == repeatDiceRoll && pointNumber == 6 || pointNumber == repeatDiceRoll && pointNumber == 8) {
                        playerBalance += (playerPointBet * 1.2) + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your second Bet: " + playerPointBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();
                        // if dice is 6 or 8
                    } else if (repeatDiceRoll == CrapsGame.comeOutRoll) {
                        playerBalance += openingBet + openingBet;
                        System.out.println("Your first Bet: " + openingBet + " Your winnings: " + playerBalance);
                        CrapsGame.winningRoll();
                        CrapsGame.gameStart();

                    } else if (repeatDiceRoll == 7) {
                        CrapsGame.losingRoll();
                        CrapsGame.gameStart();
                    }
                }
                case "NO-WAGER":
                    CrapsGame.pointRollDice();
                    CrapsGame.gameStart();
                }
                return 0;
        }
    }




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

