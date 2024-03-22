package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame implements GameInterface {
    private final NumberGuessPlayer player;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public NumberGuessGame(CasinoAccount casinoAccount, NumberGuessPlayer player) {
        this.player = player;
    }

    public static int getRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(11); // 0-10 numbers
        return randomNumber;
    }
    @Override
    public void run() {
        int randomGuess = getRandomNumber();
        System.out.println("\uD835\uDD4E\uD835\uDD56\uD835\uDD5D\uD835\uDD54\uD835\uDD60\uD835\uDD5E\uD835\uDD56 \uD835\uDD65\uD835\uDD60 ℕ\uD835\uDD66\uD835\uDD5E\uD835\uDD53\uD835\uDD56\uD835\uDD63 \uD835\uDD3E\uD835\uDD66\uD835\uDD56\uD835\uDD64\uD835\uDD64❕");
        System.out.println("⠀⠀⠀⣀⣤⣶⡶⠿⢿⣿⣶⣶⣤⣀⠀⠀⠀\n" +
                "⠀⢀⣾⣿⠋⠁⠀⠀⠀⠀⠙⢿⣿⣿⣷⣄⠀\n" +
                "⠀⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⡄\n" +
                "⠘⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡇\n" +
                "⠀⠹⢿⣿⠟⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⠇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⠟⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡿⠋⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⠟⠁⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡿⠁⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣾⡏⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢰⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("Feeling lucky? Ok, I'm thinking of a number between 0 and 10");
        while (true) {
            System.out.println("Enter your guess :");
            int input = scanner.nextInt();

            if (input > randomGuess) {
                System.out.println("Your guess is too high.");
            } else if (input < randomGuess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            }
        }
    }


    @Override
    public boolean getWinner() {
        return false;
    }

    @Override
    public void add(PlayerInterface player) {

    }
}

