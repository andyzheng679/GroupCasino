package com.github.zipcodewilmington.casino.games.Roulette;

// implementation for betting on a specific single number
public class StraightBet implements Bet {
    private final int number;
    private final double amount;
    public StraightBet(int number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    @Override
    public boolean isWin(Pocket result) {
        return result.getNumber() == number;
    }
    @Override
    public double getPayoutAmount() {
        return amount * 36; // straight single number bet pays 35:1
    }
}