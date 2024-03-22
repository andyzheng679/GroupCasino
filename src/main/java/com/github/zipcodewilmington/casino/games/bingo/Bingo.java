package com.github.zipcodewilmington.casino.games.bingo;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.*;

public class Bingo implements GameInterface {
    //private ArrayList<Integer> answerList;
    private ArrayList<BingoPlayer> playerList;
    Random rand = new Random();
    BingoBoard bingoBoard = new BingoBoard();


    public Bingo() {
        //answerList = new ArrayList<Integer>();
        playerList = new ArrayList<>();

    }

    public Integer announceNumber(){
        Integer nextNumber = rand.nextInt(75)+1;
        while (bingoBoard.checkNumber(nextNumber)) {
            nextNumber = rand.nextInt(75) + 1;
        }
        bingoBoard.setNumberAsCalled(nextNumber);

        for(BingoPlayer bPlayer :playerList){
            bPlayer.getBingoCard().markNumber(nextNumber);
        }

        return nextNumber;
    }


//    public boolean checkWinner(){
//        for(BingoPlayer bPlayer :playerList){
//            if(bPlayer.getBingoCard().checkBingo()){
//                System.out.println("Congrats " + bPlayer.getName() + " you have won!!!");
//                return true;
//            }
//        }
//        return false;
//    }

//    public void run() {
//        Bingo bingoGame = new Bingo();
//        BingoPlayer player1 = new BingoPlayer();
//        //BingoPlayer player2 = new BingoPlayer("Jerry");
//        bingoGame.addPlayer(player1);
//        //bingoGame.addPlayer(player2);
//        while(bingoGame.checkWinner()!= true){
//            Integer calledNumber = bingoGame.announceNumber();
//            //player1.getBingoCard().markNumber(calledNumber);
//            //player2.getBingoCard().markNumber(calledNumber);
//            System.out.println(calledNumber);
//            System.out.println(player1.getBingoCard());
//            //System.out.println(player2.getBingoCard());
//            //Scanner sc = new Scanner(System.in);
//            //String userInput = sc.next();
//        }
//    }

    public void run() {

        while(this.getWinner()!= true){
            Integer calledNumber = this.announceNumber();
            System.out.println("Called Number: "+ calledNumber);
            for(BingoPlayer bPlayer :playerList){
                System.out.println(bPlayer.getBingoCard());
                System.out.println("READY! Enter yes to get next number");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.next();
            }
        }
    }

    @Override
    public boolean getWinner() {
        for(BingoPlayer bPlayer :playerList){
            if(bPlayer.getBingoCard().checkBingo()){
                System.out.println("Congrats " + bPlayer.getName() + " you have won!!!\n");
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(PlayerInterface player) {
        playerList.add((BingoPlayer) player);

    }


}


