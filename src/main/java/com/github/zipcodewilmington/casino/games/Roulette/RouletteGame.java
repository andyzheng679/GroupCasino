package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RouletteGame implements GameInterface {
    private final List<Pocket> wheel = new ArrayList<>();
    private final List<Bet> bets = new ArrayList<>();
    private RoulettePlayer player;
    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    public RouletteGame(CasinoAccount casinoAccount, RoulettePlayer player) {
        this.player = player;
        initializeWheel();
    }

    private void initializeWheel() {
        //  made wheel with 18 red pockets , 18 black pockets, and 1 green pocket
        for (int i = 1; i <= 36; i++) {
            String color = (i % 2 == 0) ? "Black" : "Red";
            wheel.add(new Pocket(i, color));
        } // adding 0 to green pocket
        wheel.add(new Pocket(0, "Green"));
    }


    // main game loop and display welcome message
    @Override
    public void run() {
        boolean keepRunning = true;
        System.out.println(
                "  \n" +
                        "                    Welcome to the Tucana Roulette Game! \n" +
                        "     ====================================================================|\n" +
                        "   /  |-----------------------------------------------------------------||\n" +
                        "  /   | (3)| (6)| (9)|(12)|(15)|(18)|(21)|(24)|(27)|(30)|(33)|(36)|     ||\n" +
                        " /    |----|----|----|----|----|----|----|----|----|----|----|----|-----||\n" +
                        "{ (0) | (2)| (5)| (8)|(11)|(14)|(17)|(20)|(23)|(26)|(29)|(32)|(35)|     ||\n" +
                        " \\    |----|----|----|----|----|----|----|----|----|----|----|----|-----||\n" +
                        "  \\   | (1)| (4)| (7)|(10)|(13)|(16)|(19)|(22)|(25)|(28)|(31)|(34)|     ||\n" +
                        "   \\  |------------------------------------------------------------=====||\n" +
                        "      ||       EVEN     |    RED    |    BLACK    |       ODD      ||  \n" +
                        "      ||===========================================================||\n" +
                        " ");
        while (keepRunning) {
            System.out.println("\nPlayer Balance: $" + player.getBalance());
            System.out.println("1. Color Bet: Choose Red or Black.");
            System.out.println("2. Straight Number Bet: Bet on a single number from 0 to 36.");
            System.out.println("3. Even/Odd Bet: Predict whether the ball lands on an even or odd number.");
            System.out.println("4. Spin the Wheel: Confirm your bets and spin the wheel.");
            System.out.println("5. Quit: Exit the game");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    placeColorBet();
                    break;
                case 2:
                    placeStraightBet();
                    break;
                case 3:
                    placeEvenOddBet();
                    break;
                case 4:
                    spinWheelAndCalculate();
                    break;
                case 5:
                    System.out.println("Thank you for playing! Your final balance is $" + player.getBalance());
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }


    // method for placing color bet
    private void placeColorBet() {
        System.out.print("Enter color (Red/Black): ");
        String color = sc.next();
        System.out.println("Enter bet amount: ");
        double amount = sc.nextDouble();

        if (validateBet(amount)) {
            bets.add(new ColorBet(color, amount));
            player.updateBalance(-amount);
        }
    }

    // method for placing straight bet
    private void placeStraightBet() {
        System.out.print("Enter number (0-36): ");
        int number = sc.nextInt();
        System.out.println("Enter bet amount: ");
        double amount = sc.nextDouble();
        if (validateBet(amount)) {
            bets.add(new StraightBet(number, amount));
            player.updateBalance(-amount);
        }
    }

    // method for placing even/odd bet
    private void placeEvenOddBet() {
        System.out.print("Enter choice (Even/Odd): ");
        String evenOrOdd = sc.next();
        System.out.println("Enter bet amount: ");
        double amount = sc.nextDouble();
        if (validateBet(amount)) {
            bets.add(new EvenOddBet(evenOrOdd, amount));
            player.updateBalance(-amount);
        }
    }

    // validate/confirm player bet amount against balance
    public boolean validateBet(double amount) {
        if (amount > 0 && amount <= player.getBalance()) {
            return true;
        } else {
            System.out.println("Invalid bet amount. Your balance is $" + player.getBalance());
            return false;
        }
    }


    // spins roulette win and calculate win/loss
    public void spinWheelAndCalculate() {
        int index = random.nextInt(wheel.size());
        Pocket result = wheel.get(index);
        System.out.println("Roulette Wheel landed on: " + result.getNumber() + " " + result.getColor());

        double totalWin = 0;
        for (Bet bet : bets) {
            if (bet.isWin(result)) {
                double winnings = bet.getPayoutAmount();
                totalWin += winnings;
                System.out.println("You win: $" + winnings);
            }
        }
        player.updateBalance(totalWin);
        bets.clear(); // clear out bets for the next round
    }

    @Override
    public boolean getWinner() {
        return player.getBalance() >0 ;
    }
    @Override
    public void add(PlayerInterface player) {
        this.player = (RoulettePlayer) player;
    }
}




