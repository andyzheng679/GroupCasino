package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RoulettePlayerTest {
    private CasinoAccount casinoAccount;
    private RoulettePlayer roulettePlayer;
    private final String accountName = "markzuckkkk";
    private final String accountPassword = "fang"; //lol
    private final double initialBalance = 100.0;

    @Before
    public void setUp() {
        casinoAccount = new CasinoAccount(accountName, accountPassword);
        casinoAccount.depositToBalance(initialBalance);
        roulettePlayer = new RoulettePlayer(casinoAccount);
    }
    @Test // testing name
    public void testGetName() {
        assertEquals(accountName, roulettePlayer.getName());
    }

    @Test // testing balance
    public void testGetBalance() {
        assertEquals(initialBalance, roulettePlayer.getBalance());
    }

    @Test
    public void testUpdateBalanceIncreasing(){ // testing account balance increasing
        double amountToAdd = 100.0;
        double expectedNewBalance = initialBalance + amountToAdd;

        roulettePlayer.updateBalance(amountToAdd);

        assertEquals(expectedNewBalance, roulettePlayer.getBalance());
    }

    @Test
    public void testUpdateBalanceDecreasing() { // testing account balance decreasing
        double amountToSubtract = -100.0;
        double expectedNewBalance = initialBalance + amountToSubtract;

        roulettePlayer.updateBalance(amountToSubtract);

        assertEquals(expectedNewBalance, roulettePlayer.getBalance());
    }
    @Test //testing account
    public void testGetArcadeAccount() {
        assertEquals(casinoAccount, roulettePlayer.getArcadeAccount());
    }
}

