package com.github.zipcodewilmington.casino.games.Roulette;

public class Pocket { // roulette wheel pocket / numbers and colors
    private final int number;
    private final String color;
    public Pocket(int number, String color) {
        this.number = number;
        this.color = color;
    }
    public int getNumber() {
        return number;
    }
    public String getColor() {
        return color;
    }
}
