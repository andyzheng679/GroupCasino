package com.github.zipcodewilmington.casino.games.bingo;


import java.util.Random;

public class BingoCard {
    private int BOARD_SIZE = 5;
    Integer[][] bingoCard;
    String[][] markedCard;
    Random rand = new Random();
    BingoBoard initializedboard = new BingoBoard();
    String symbol = "X";

    public BingoCard() {
        this.bingoCard = new Integer[BOARD_SIZE][BOARD_SIZE];
        this.markedCard = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(i == 2 && j==2){
                    this.bingoCard[i][j] = 0;
                    this.markedCard[i][j] = symbol;
                    continue;
                }
                int addFactor = (j * 15) + 1;
                int randNumber = rand.nextInt(14) + addFactor;
                while (initializedboard.checkNumber(randNumber)) {
                    randNumber = rand.nextInt(14) + addFactor;
                }
                this.bingoCard[i][j] = randNumber;
                initializedboard.setNumberAsCalled(randNumber);
                this.markedCard[i][j] = String.valueOf(randNumber);

            }

        }
    }

    public void markNumber(int number){
        // in marked number first i have to take random number
        // then check if there is number in the board
        // and if yes mark it with X



    }

    public boolean checkBingo(){
        return true;
    }

    // checkBingo();
    // MarkNumber(int number);
    // Override toString() to print the card


    public static void main(String args[]){
        BingoCard card = new BingoCard();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(card.markedCard[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}

