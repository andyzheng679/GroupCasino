package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {
    private final CasinoAccount arcadeAccount;


    public RoulettePlayer(CasinoAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    public String getName() {
        return arcadeAccount.getAccountName();
    }

    public double getBalance() {
        return arcadeAccount.getAccountBalance();
    }

    public void updateBalance(double amount) {
        double newBalance = arcadeAccount.getAccountBalance() + amount;
        arcadeAccount.setAccountBalance(newBalance);
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.arcadeAccount;
    }
}
