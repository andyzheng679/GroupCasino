package com.github.zipcodewilmington.casino.games.Roulette;

public class EvenOddBet implements Bet { // implementation for betting on even or odd number
    private final String evenOrOdd;
    private final double amount;
    public EvenOddBet(String evenOrOdd, double amount) {
        this.evenOrOdd = evenOrOdd;
        this.amount = amount;
    }
    @Override
    public boolean isWin(Pocket result) {
        if (result.getNumber() == 0) // 0 is neither even nor odd
            return false;
        boolean isEven = result.getNumber() % 2 == 0;
        return (isEven && "Even".equalsIgnoreCase(evenOrOdd)) || (!isEven && "Odd".equalsIgnoreCase(evenOrOdd));
    }
    @Override
    public double getPayoutAmount() {
        return amount * 2; // even/odd bet pays 1:1
    }
}
