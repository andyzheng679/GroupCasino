package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.Roulette.Bet;
import com.github.zipcodewilmington.casino.games.Roulette.Pocket;
import com.github.zipcodewilmington.casino.games.Roulette.StraightBet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StraightBetTest { // specific num bet
    @Test
    public void testIsWinWinningResult() {
        Bet bet = new StraightBet(1, 100);
        Pocket winningPocket = new Pocket(1, "Red");

        assertTrue(bet.isWin(winningPocket));
    }

    @Test
    public void testIsWinLosingResult() {
        Bet bet = new StraightBet(1, 100);

        Pocket losingPocket = new Pocket(2, "Black");
        assertFalse(bet.isWin(losingPocket));

    }

    @Test
    public void testPayoutAmount() {
        Bet bet = new StraightBet(1, 100);

        assertEquals(3600, bet.getPayoutAmount());
    }
}
