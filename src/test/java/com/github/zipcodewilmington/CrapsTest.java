package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.craps.CrapsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void testDiceRoll() {
        // Given
        int diceOne = CrapsPlayer.dieOne;
        int diceTwo = CrapsPlayer.dieTwo;
        int sumOfDice = diceOne + diceTwo;

        // expected
        boolean expectedSum = diceTwo >= 2 && diceTwo <= 12 || diceOne >= 2 && diceOne <= 12;

        // actual
        boolean actualSum = sumOfDice >= 2 && sumOfDice <= 12;

        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testWinningRoll() {
        int num = CrapsPlayer.diceRoll();
        int winningNumOne = 7;
        int winningNumTwo = 11;

        boolean expectedWinningGame = num == 7 || num == 11;

        boolean actualWinningGame = num == winningNumOne || num == winningNumTwo ;

        Assert.assertEquals(expectedWinningGame, actualWinningGame);
    }

    @Test
    public void testLosingRoll() {
        int num = CrapsPlayer.diceRoll();
        int losingNumOne = 2;
        int losingNumTwo = 3;
        int losingNumThree = 12;

        boolean expectedLosingGame = num == 2 || num == 3 || num == 12;

        boolean actualLosingGame = num == losingNumOne || num == losingNumTwo || num == losingNumThree ;

        Assert.assertEquals(expectedLosingGame, actualLosingGame);
    }

    @Test
    public void testPointRoll() {
        int num = CrapsPlayer.diceRoll();

    }


}
