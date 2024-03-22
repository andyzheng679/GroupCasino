package com.github.zipcodewilmington.casino.games.Backjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

public class Blackjack implements GameInterface {

    public BlackjackPlayer player;
    public BlackjackPlayer dealer;
    private DeckofCards deck;
    private CasinoAccount casinoAccount;

    public Blackjack(CasinoAccount playerAccount, CasinoAccount dealerAccount) {
        this.player = new BlackjackPlayer(playerAccount);
        this.dealer = new BlackjackPlayer(dealerAccount);
        this.deck = new DeckofCards();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Your current balance: " + player.getArcadeAccount().getAccountBalance());
            System.out.print("Enter your bet amount: ");
            double betAmount;
            try {
                betAmount = Double.parseDouble(scanner.nextLine());
                while (betAmount > player.getArcadeAccount().getAccountBalance()) {
                    System.out.println("Insufficient balance. Please enter a lower bet.");
                    betAmount = Double.parseDouble(scanner.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            player.getArcadeAccount().setAccountBalance(player.getArcadeAccount().getAccountBalance() - betAmount);

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
                if (player.sumOfHand() < 21 && player.hitOrStand(scanner)) {
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
            boolean dealerBusted = dealer.sumOfHand() > 21;

            if (playerBusted || (!playerBusted && !getWinner())) {
                System.out.println("Dealer wins! You lost " + betAmount + " units.");
            } else {
                double winnings = betAmount * 2; // Or other payout rate
                System.out.println("You win! You gained " + winnings + " units.");
                player.getArcadeAccount().setAccountBalance(player.getArcadeAccount().getAccountBalance() + winnings);
            }

            // Ask if the player wants to play another round
            System.out.println("Do you want to play another round? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase(); // Using nextLine to avoid input issues
            if (!"yes".equals(answer)) {
                playAgain = false;
            }
        }


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


@Override
public void add(PlayerInterface player) {
    this.player = (BlackjackPlayer) player;
}
}

