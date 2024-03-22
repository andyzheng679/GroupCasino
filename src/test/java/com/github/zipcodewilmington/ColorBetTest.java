package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.Roulette.Bet;
import com.github.zipcodewilmington.casino.games.Roulette.ColorBet;
import com.github.zipcodewilmington.casino.games.Roulette.Pocket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ColorBetTest {

    @Test // testing and confirming win
    public void testIsWinWinningResult() {
        Bet bet = new ColorBet("Red", 100);
        Pocket winningPocket = new Pocket(1, "Red");

        assertTrue(bet.isWin(winningPocket));
    }

    @Test // testing and confirming lost
    public void testIsWinLosingResult() {
        Bet bet = new ColorBet("Red", 100);
        Pocket losingPocket = new Pocket(2, "Black");

        assertFalse(bet.isWin(losingPocket));
    }

    @Test // testing and confirming payout
    public void testPayoutAmount() {
        Bet bet = new ColorBet("Red", 100);

        assertEquals(200, bet.getPayoutAmount(), 0.01);
    }
}
