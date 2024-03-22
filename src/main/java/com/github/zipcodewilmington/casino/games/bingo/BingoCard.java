package com.github.zipcodewilmington.casino.games.bingo;


import java.util.Random;

public class BingoCard {
    private int BOARD_SIZE = 5;
    Integer[][] bingoCard;
    String[][] markedCard;
    Random rand = new Random();
    BingoBoard initializedboard = new BingoBoard();


    public String[][] getMarkedCard() {
        return markedCard;
    }

    public Integer[][] getBingoCard() {
        return bingoCard;
    }

    public BingoCard() {
        this.bingoCard = new Integer[BOARD_SIZE][BOARD_SIZE];
        this.markedCard = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 2 && j == 2) {
                    this.bingoCard[i][j] = 0;
                    //this.markedCard[i][j] = "⭐";
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

        //Marking free space
        markNumber(0);
    }

    // Create Mark Number method
    public void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingoCard[i][j] == number) {
                    markedCard[i][j] = "⭐️";
                }

            }
        }

    }

    // Create check Bingo method
    public boolean checkBingo() {
        //Checking Rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (this.markedCard[i][0] == "⭐️" && this.markedCard[i][1] == "⭐️" && this.markedCard[i][2] == "⭐️" && this.markedCard[i][3] == "⭐️" && this.markedCard[i][4] == "⭐️") {
                return true;
            }

            if (this.markedCard[0][i] == "⭐️" && this.markedCard[1][i] == "⭐️" && this.markedCard[2][i] == "⭐️" && this.markedCard[3][i] == "⭐️" && this.markedCard[4][i] == "⭐️") {
                return true;
            }
        }

        // Checking Diagonally
        if (this.markedCard[0][0] == "⭐️" && this.markedCard[1][1] == "⭐️" && this.markedCard[2][2] == "⭐️" && this.markedCard[3][3] == "⭐️" && this.markedCard[4][4] == "⭐️") {
            return true;
        } else if (this.markedCard[0][4] == "⭐️" && this.markedCard[1][3] == "⭐️" && this.markedCard[2][2] == "⭐️" && this.markedCard[3][1] == "⭐️" && this.markedCard[4][0] == "⭐️") {
            return true;
        } else
            return false;


    }


    // Override toString() to print the card

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("___________________________\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            //sb.append("|---|---|---|---|---|");
            for (int j = 0; j < 5; j++) {
                sb.append(" | ");
                sb.append(markedCard[i][j]);
            }
            sb.append(" |");
            sb.append("\n");
            sb.append("____________________________\n");
        }
        return sb.toString();

    }


//    public static void main(String args[]) {
//        BingoCard card = new BingoCard();
//        System.out.println(card);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(card.markedCard[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
    // }
}


