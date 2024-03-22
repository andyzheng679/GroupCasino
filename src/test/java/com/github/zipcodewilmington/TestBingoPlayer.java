package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.bingo.BingoPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBingoPlayer {
    BingoPlayer player;
    CasinoAccount ca;
    @Before
    public void setupPlayer(){
         ca = new CasinoAccount("Bob","Bob123");
         player = new BingoPlayer(ca);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Bob",player.getName());
    }

    @Test
    public void testGetArcadeAcc(){
        Assert.assertEquals(ca,player.getArcadeAccount());
    }
}
