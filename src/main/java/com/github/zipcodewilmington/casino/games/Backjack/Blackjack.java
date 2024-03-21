package com.github.zipcodewilmington.casino.games.Backjack;

import com.github.zipcodewilmington.casino.GameInterface;

import java.util.Scanner;

public class Blackjack implements GameInterface {

    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private DeckofCards deck;

    public Blackjack(){
        this.player = new BlackjackPlayer();
        this.dealer = new BlackjackPlayer();
        this.deck = new DeckofCards();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);  // Scanner for player input
        boolean playAgain = true;

        while (playAgain) {
            deck.resetDeck(); // Prepare a new deck for the game
            player.playerHand.clear(); // Reset player's hand
            dealer.playerHand.clear(); // Reset dealer's hand

            // Deal two cards each to start the game
            for (int i = 0; i < 2; i++) {
                player.playerHand.add(deck.drawCard());
                dealer.playerHand.add(deck.drawCard());
            }

            // Show initial hands
            System.out.println("Your hand: " + player.playerHand);
            System.out.println("Dealer's hand: " + dealer.playerHand.get(0) + ", [Hidden]");

            // Player's turn
            boolean playerBusted = false;
            boolean playerTurn = true;
            while (playerTurn && !playerBusted) {
                if (player.sumOfHand() < 21 && player.hitOrStand()) {
                    player.playerHand.add(deck.drawCard());
                    System.out.println("Your hand: " + player.playerHand);
                    if (player.sumOfHand() > 21) {
                        System.out.println("You bust!");
                        playerBusted = true;
                    }
                } else {
                    playerTurn = false;
                }
            }

            // Dealer's turn (if the player hasn't busted)
            if (!playerBusted) {
                System.out.println("Dealer's hand: " + dealer.playerHand);
                dealer.dealerAction(deck);
                System.out.println("Dealer's final hand: " + dealer.playerHand);
            }

            // Determine and announce the winner
            if (playerBusted || (!playerBusted && !getWinner())) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("You win!");
            }

            // Ask if the player wants to play another round
            System.out.println("Do you want to play another round? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!"yes".equals(answer)) {
                playAgain = false;
            }
        }

        scanner.close(); // Close scanner at the end of the game
    }

    public boolean getWinner() {
        int playerHandValue = player.sumOfHand();
        int dealerHandValue = dealer.sumOfHand();

        if (playerHandValue > 21) {
            return false;
        }

        if (dealerHandValue > 21) {
            return true;
        }

        return playerHandValue > dealerHandValue;
    }
}

