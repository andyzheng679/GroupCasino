package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.bingo.Bingo;
import com.github.zipcodewilmington.casino.games.bingo.BingoPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBingoGame {
    Bingo game;
    CasinoAccount ca;
    @Before
    public void initialize(){
        game = new Bingo();
        ca = new CasinoAccount("Bob","Bob123");


    }
    @Test
    public void testAnnouncer(){
        Integer actual = game.announceNumber();
        Assert.assertTrue(actual>1 && actual<=75);
    }

//    @Test
//    public void teatGetWinner(){
//       BingoPlayer player = new BingoPlayer(ca);
//       Integer[] values = new Integer[5];
//       values = player.getBingoCard().getBingoCard()[0];
//       Assert.assertEquals(false,game.getWinner());
//       for(Integer val : values){
//           player.getBingoCard().markNumber(val);
//       }
//       Assert.assertEquals(true,game.getWinner());
//       System.out.println(player.getBingoCard());
//
//       Assert.assertEquals(false,game.getWinner());
//       for(int i = 0; i<75; i++){
//           player.getBingoCard().markNumber(i);
//       }
//       Assert.assertEquals(true,game.getWinner());
   // }
}
