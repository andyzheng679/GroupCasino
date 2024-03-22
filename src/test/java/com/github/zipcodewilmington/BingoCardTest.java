package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.bingo.BingoCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BingoCardTest {
    BingoCard bingocard;

    @Before
    public void initializeConstructor() {
        bingocard = new BingoCard();
    }

    @Test
    public void testConstructor(){
        String expected = "⭐️";
        Assert.assertEquals(expected,bingocard.getMarkedCard()[2][2]);
    }
    @Test
    public void testCheckAndMark(){
        Integer[] values = new Integer[5];
        values = bingocard.getBingoCard()[0];
        Assert.assertEquals(false,bingocard.checkBingo());
        for(Integer val : values){
            bingocard.markNumber(val);
        }
        Assert.assertEquals(true,bingocard.checkBingo());
    }
}
