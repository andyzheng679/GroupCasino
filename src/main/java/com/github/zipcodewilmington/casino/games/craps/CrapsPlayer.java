package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

public class CrapsPlayer implements PlayerInterface {

    public static Random rand = new Random();
    public static int dieOne;
    public static int dieTwo;
    public static int currentRoll;
    public static String rollsDiceOption;
    public static String secondaryWager;
    public static double playerPointBet;
    public static double playerPassLineBet;
    public static int pointNumber;
    public static double playerBalance = CrapsGame.userBalance;
    public static double payOut;
    private CasinoAccount arcadeAccount;
    private static final IOConsole console = new IOConsole(AnsiColor.CYAN);
    private static final IOConsole red = new IOConsole(AnsiColor.RED);


    public CrapsPlayer() {

    }
    public CrapsPlayer(CasinoAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return arcadeAccount;
    }

    public static int diceRoll() {
        dieOne = rand.nextInt(7 - 1) + 1;
        dieTwo = rand.nextInt(7 - 1) + 1;
        return currentRoll = dieOne + dieTwo;
    }

    public static void userInputRoll() {
        rollsDiceOption = console.getStringInput( "\n-<>-<>-<>-<>-<>-<>-<>-<>-\n" +
                "Please Roll the dice:\n[roll]");
        console.println("-<>-<>-<>-<>-<>-<>-<>-<>-\n");
    }

    public static String secondaryWagerOption() {
        return secondaryWager = console.getStringInput("Would you like to add another wager?\n [ PASS-LINE ] [ POINT ] [ SKIP ]").toUpperCase();
    }

    public static void secondaryWager() {
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
                    red.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");


                    if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 4 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 10) {
                        payOut = (playerPassLineBet * 2) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        red.println("You rolled: " + repeatDiceRoll);
                        red.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPassLineBet + "] Your winnings: {" + payOut + "}");
                        // if dice is 4 or 10
                        break;
                    } else if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 5 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 9) {
                        payOut += (playerPassLineBet * 1.5) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        red.println("You rolled: " + repeatDiceRoll);
                        red.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPassLineBet + "] Your winnings: {" + payOut + "}");
                        // if dice is 5 or 9
                        break;
                    } else if (CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 6 || CrapsGame.comeOutRoll == repeatDiceRoll && repeatDiceRoll == 8) {
                        payOut += (playerPassLineBet * 1.2) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        red.println("You rolled: " + repeatDiceRoll);
                        red.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPassLineBet + "] Your winnings: {" + payOut + "}");
                        // if dice is 6 or 8
                        break;
                    } else if (repeatDiceRoll == CrapsGame.comeOutRoll) {
                        payOut += CrapsGame.playerBet + CrapsGame.playerBet;
                        playerBalance += payOut;
                        red.println("You rolled: " + repeatDiceRoll);
                        red.println("Your first Bet: [" + CrapsGame.playerBet + "] Your winnings: {" + payOut + "}");
                        break;
                    } else if (repeatDiceRoll == 7) {
                        payOut += CrapsGame.playerBet + playerPassLineBet;
                        playerBalance -= payOut;
                        red.println("You rolled: " + repeatDiceRoll);
                        red.println("You lost! {You lost: " + payOut + "}");
                        break;
                    } else if (repeatDiceRoll != 7 || repeatDiceRoll != CrapsGame.comeOutRoll()) {
                        red.println(
                                "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                                        "You rolled a {" + repeatDiceRoll + "} which is not {" + CrapsGame.comeOutRoll + "} or {7}, Roll again." +
                                        "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                    }

                }
                break;

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
                    console.println("Dice: [" + diceOne + "] Dice: [" + diceTwo + "]");

                    if (pointNumber == repeatDiceRoll && pointNumber == 4 || pointNumber == repeatDiceRoll && pointNumber == 10) {
                        payOut += (playerPointBet * 2) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        console.println("You rolled: " + repeatDiceRoll);
                        console.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPointBet + "] Your winnings: {" + payOut + "}");
                        break;
                        // if dice is 4 or 10
                    } else if (pointNumber == repeatDiceRoll && pointNumber == 5 || pointNumber == repeatDiceRoll && pointNumber == 9) {
                        payOut += (playerPointBet * 1.5) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        console.println("You rolled: " + repeatDiceRoll);
                        console.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPointBet + "] Your winnings: {" + payOut + "}");
                        break;
                        // if dice is 5 or 9
                    } else if (pointNumber == repeatDiceRoll && pointNumber == 6 || pointNumber == repeatDiceRoll && pointNumber == 8) {
                        payOut += (playerPointBet * 1.2) + CrapsGame.playerBet;
                        playerBalance += payOut;
                        console.println("You rolled: " + repeatDiceRoll);
                        console.println("Your first Bet: [" + CrapsGame.playerBet + "] Your second Bet: [" + playerPointBet + "] Your winnings: {" + payOut + "}");
                        break;
                        // if dice is 6 or 8
                    } else if (repeatDiceRoll == CrapsGame.comeOutRoll) {
                        payOut += CrapsGame.playerBet + CrapsGame.playerBet;
                        playerBalance += payOut;
                        console.println("You rolled: " + repeatDiceRoll);
                        console.println("Your first Bet: [" + CrapsGame.playerBet + "] Your winnings: {" + payOut +"}");
                        break;
                    } else if (repeatDiceRoll == 7) {
                        payOut += CrapsGame.playerBet + playerPassLineBet;
                        playerBalance -= payOut;
                        console.println("You rolled: " + repeatDiceRoll);
                        console.println("You lost! [You lost: " + payOut + "]");
                        break;
                    }else if (repeatDiceRoll != 7 || repeatDiceRoll != CrapsGame.comeOutRoll() || repeatDiceRoll != pointNumber) {

                        console.println(
                                "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                                        "You rolled a {" + repeatDiceRoll + "} which is not {" + pointNumber + "}, {" + CrapsGame.comeOutRoll + "} or {7}, Roll again." +
                                        "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    }
                }
                break;
            case "SKIP":
                CrapsGame.pointRollDice();
                break;
        }


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
