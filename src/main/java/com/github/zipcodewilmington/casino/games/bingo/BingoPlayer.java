package com.github.zipcodewilmington.casino.games.bingo;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BingoPlayer implements PlayerInterface {
    private String name;
    private BingoCard bingocard;

    public BingoPlayer(String name) {
        this.name = name;
        this.bingocard = new BingoCard();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BingoCard getBingoCard() {
        return bingocard;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }


}
