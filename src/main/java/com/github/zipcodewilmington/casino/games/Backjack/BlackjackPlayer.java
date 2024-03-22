package com.github.zipcodewilmington.casino.games.Backjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackPlayer implements PlayerInterface {
    public ArrayList<Cards> playerHand;    //make arraylist of Cards
    public ArrayList<Cards> splitHand;     // used for split
    int handValue;      //keeps tracks of hand
    private Scanner scanner;
    private CasinoAccount arcadeAccount;

    //private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    //constructor
    public BlackjackPlayer(){
        playerHand = new ArrayList<>();
        handValue = 0;
        scanner = new Scanner(System.in);
    }

    public BlackjackPlayer(CasinoAccount arcadeAccount) {

        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return arcadeAccount;
    }

    //testing
    public BlackjackPlayer(Scanner scanner) {
        this.playerHand = new ArrayList<>();
        this.handValue = 0;
        this.scanner = scanner;
    }

    //sum hand, checks for ace cards
    public int sumOfHand() {
        int aceCounter = 0; // Count aces if there are any
        int totalValue = 0; // Variable to hold the total hand value

        // Iterate through each card in the player's hand
        for (Cards card : playerHand) {
            int value = card.getValue(); // Get value from the card
            totalValue += value; // Add the card value to the total

            // If the card is an ace, increment the aceCounter
            if (value == 11) {
                aceCounter++;
            }
        }

        // Adjust the total value if there are aces and the total exceeds 21
        while (totalValue > 21 && aceCounter > 0) {
            totalValue -= 10; // Change the value of the ace from 11 to 1
            aceCounter--; // Decrement the aceCounter
        }

        return totalValue; // Return the final total hand value
    }


    public boolean hitOrStand(){
        System.out.println("Hit or Stand, enter 'hit'/'stand': ");
        boolean validInput = false;
        boolean doTheyHit = false;

        while(!validInput){
            String userInput = scanner.nextLine().toLowerCase();
            if(userInput.equals("hit")){
                doTheyHit = true;
                validInput = true;
            } else if (userInput.equals("stand")) {
                validInput = true;
            }else{
                System.out.println("Invalid input, enter 'hit' or 'stand': ");
            }
        }
        return doTheyHit;
    }


    public boolean doubleDown(){
        System.out.println("Do you want to double down? 'Y', 'N': ");
        boolean validInput = false;
        boolean doTheyDouble = false;

        while (!validInput){
            String userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("Y")){
                validInput = true;
                doTheyDouble = true;
            } else if (userInput.equals("N")) {
                validInput = true;
            }
        }
        return doTheyDouble;
    }

    public boolean split(){
        if(playerHand.size() == 2 && playerHand.get(0).getValue() == playerHand.get(1).getValue()){
            System.out.println("Your cards can be split, do you want to split, 'Y', 'N': ");

            while(true){
                String userInput = scanner.nextLine().toUpperCase();

                if(userInput.equals("Y")){
                    if (splitHand == null){
                        splitHand = new ArrayList<>();
                    }else {
                        splitHand.clear();
                    }
                    splitHand.add(playerHand.remove(1));

                    return true;
                } else if (userInput.equals("N")) {
                    return false;
                }else {
                    System.out.println("Not a valid input, enter 'Y'/ 'N': ");
                }
            }
        }else {
            System.out.println("Can't split these cards.");
            return false;
        }
    }

    public boolean surrender(){
        System.out.println("Would you like to surrender? 'Y'/ 'N': ");
        while (true){
            String userInput = scanner.nextLine().toUpperCase();
            if(userInput.equals("Y")){
                return true;
            } else if (userInput.equals("N")) {
                return false;
            }else {
                System.out.println("Invalid input.");
            }
        }
    }

    public void dealerAction(DeckofCards deck) {

        while (sumOfHand() < 17) {
            Cards drawnCard = deck.drawCard();
            playerHand.add(drawnCard);
            System.out.println("Dealer draws: " + drawnCard);

        }
    }


}

