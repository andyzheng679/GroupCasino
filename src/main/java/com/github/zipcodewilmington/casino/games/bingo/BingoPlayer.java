package com.github.zipcodewilmington.casino.games.bingo;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BingoPlayer implements PlayerInterface {
    private String name;
    private BingoCard bingocard;
    private CasinoAccount arcadeAccount;

    public BingoPlayer(CasinoAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
        this.name = arcadeAccount.getAccountName();
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
        return arcadeAccount;
    }


}
