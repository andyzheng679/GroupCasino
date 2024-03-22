package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class NumberGuessPlayerTest {
    private NumberGuessPlayer player;
    private CasinoAccount account;

    @Before
    public void setUp() { // testing set up
        account = new CasinoAccount("danny", "skylinegtr");
        player = new NumberGuessPlayer(account);
        player.setPlayerName("mynamejeffff");
    }

    @Test // testing for player name
    public void testGetPlayerName() {
        assertEquals("mynamejeffff", player.getPlayerName());
    }

    @Test // testing for account
    public void testGetArcadeAccount() {
        assertEquals(account, player.getArcadeAccount());
    }
}
