package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Roulette.Bet;
import com.github.zipcodewilmington.casino.games.Roulette.EvenOddBet;
import com.github.zipcodewilmington.casino.games.Roulette.Pocket;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvenOddBetTest {

    @Test // testing even wins
    public void testIsWinEvenWinning() {
        Bet bet = new EvenOddBet("Even", 100);
        Pocket evenPocket = new Pocket(2, "Black");
        assertTrue(bet.isWin(evenPocket));
    }

    @Test // testing odd wins
    public void testIsWinOddWinning() {
        Bet bet = new EvenOddBet("Odd", 100);
        Pocket oddPocket = new Pocket(1, "Red");
        assertTrue(bet.isWin(oddPocket));
    }

    @Test // testing if green/zero wins
    public void testIsWinZeroLosing() {
        Bet bet = new EvenOddBet("Even", 100);
        Pocket zeroPocket = new Pocket(0, "Green");
        assertFalse(bet.isWin(zeroPocket));
    }
}
