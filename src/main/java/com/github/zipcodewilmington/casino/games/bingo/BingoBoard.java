package com.github.zipcodewilmington.casino.games.bingo;

import java.util.HashMap;

public class BingoBoard {
    private HashMap<Integer, Boolean> bingoBoard;

    public BingoBoard() {
        this.bingoBoard = new HashMap<Integer, Boolean>();
        for(int i =1;i<=75;i++){
            bingoBoard.put(i, false);
        }

    }
    public boolean checkNumber(Integer number){
        return bingoBoard.get(number);
    }
    public void setNumberAsCalled(Integer num){
        bingoBoard.replace(num,true);
    }
}
