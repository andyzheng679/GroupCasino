package com.github.zipcodewilmington.casino.games.Roulette;


public class ColorBet implements Bet { //implementation for betting on a color (red or black)
    private final String color;
    private final double amount;
    public ColorBet(String color, double amount) {
        this.color = color;
        this.amount = amount;
    }

    @Override
    public boolean isWin(Pocket result) {
        return result.getColor().equalsIgnoreCase(color);
    }

    @Override
    public double getPayoutAmount() {
        return amount * 2; // color bet pays 1:1
    }

}
