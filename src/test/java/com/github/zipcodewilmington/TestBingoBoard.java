package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.bingo.BingoBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBingoBoard {

    private BingoBoard bingoboard;

    @Before
    public void initializeBoard() {
        bingoboard = new BingoBoard();

    }

    @Test
    public void testConstructor() {
        for (int i = 1; i <= 75; i++) {
            Assert.assertEquals(false, bingoboard.checkNumber(i));
        }

    }

    @Test
    public void checkAndSet(){
        bingoboard.setNumberAsCalled(7);
        Assert.assertEquals(true,bingoboard.checkNumber(7));
    }
}



