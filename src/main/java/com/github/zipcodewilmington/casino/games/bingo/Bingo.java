package com.github.zipcodewilmington.casino.games.bingo;

import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.*;

public class Bingo {
    //private ArrayList<Integer> answerList;
    private ArrayList<BingoPlayer> playerList;
    Random rand = new Random();
    BingoCard card = new BingoCard();
    BingoBoard bingoBoard = new BingoBoard();


    public Bingo() {
        //answerList = new ArrayList<Integer>();
        playerList = new ArrayList<>();

    }
    public void addPlayer(BingoPlayer player){
        playerList.add(player);
    }
    public Integer announceNumber(){
        Integer nextNumber = rand.nextInt(75)+1;
        while (bingoBoard.checkNumber(nextNumber)) {
            nextNumber = rand.nextInt(75) + 1;
        }
        bingoBoard.setNumberAsCalled(nextNumber);
        return nextNumber;
    }


    public boolean checkWinner(){
        for(BingoPlayer bPlayer :playerList){
            if(bPlayer.getBingoCard().checkBingo()){
                System.out.println("Congrats " + bPlayer.getName() + " you have won!!!");
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Bingo bingoGame = new Bingo();
        BingoPlayer player1 = new BingoPlayer("Tom");
        //BingoPlayer player2 = new BingoPlayer("Jerry");
        bingoGame.addPlayer(player1);
        //bingoGame.addPlayer(player2);
        while(bingoGame.checkWinner()!= true){
            Integer calledNumber = bingoGame.announceNumber();
            player1.getBingoCard().markNumber(calledNumber);
            //player2.getBingoCard().markNumber(calledNumber);
            System.out.println(calledNumber);
            System.out.println(player1.getBingoCard());
            //System.out.println(player2.getBingoCard());
            //Scanner sc = new Scanner(System.in);
            //String userInput = sc.next();
        }
    }



}


