package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouletteGameTest {
    private RouletteGame game;
    private CasinoAccount account;

    @Before
    public void setUp() {
        double initialBalance = 500.0;
        account = new CasinoAccount("michaeljackson", "tehe");
        account.depositToBalance(initialBalance);

        RoulettePlayer player = new RoulettePlayer(account);
        game = new RouletteGame(account, player);
    }

    @Test // testing validation of bet limit
    public void testValidateBet() {
        assertTrue(game.validateBet(500));
    }

    @Test // testing if valid bet is over limit
    public void testValidateBetTooHigh() {
        assertFalse(game.validateBet(501));
    }

    @Test // testing if valid bet is under limit
    public void testValidateBetTooLow() {
        assertFalse(game.validateBet(-1));
    }
}


