package com.github.zipcodewilmington.casino.games.Roulette;

public interface Bet { // bet interface for different types of bets
    boolean isWin(Pocket result); // check if player wins based on wheel spin result
    double getPayoutAmount(); // calculate how much to payout if player wins
}