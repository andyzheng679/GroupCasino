package com.github.zipcodewilmington.casino.games.numberguess;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class NumberGuessPlayer implements PlayerInterface {
    private final CasinoAccount casinoAccount;
    private String playerName;

    public NumberGuessPlayer(CasinoAccount casinoAccount) {
        this.casinoAccount = casinoAccount;
        this.playerName = playerName;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
