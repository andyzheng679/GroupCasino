package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

//import com.github.zipcodewilmington.casino.games.Backjack.Blackjack;
//import com.github.zipcodewilmington.casino.games.Backjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.craps.CrapsPlayer;

import com.github.zipcodewilmington.casino.games.Backjack.Blackjack;
import com.github.zipcodewilmington.casino.games.Backjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.bingo.Bingo;
import com.github.zipcodewilmington.casino.games.bingo.BingoPlayer;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    while (true){
                        String gameSelectionInput = getGameSelectionInput().toUpperCase();
                        if (gameSelectionInput.equals("SLOTS")) {
                            play(new SlotsGame(), new SlotsPlayer());
                        } else if (gameSelectionInput.equals("NUMBERGUESS")) {

                            play(new NumberGuessGame(casinoAccount, null), new NumberGuessPlayer(casinoAccount));
                        } else if (gameSelectionInput.equals("CRAPS")) {
                            play(new CrapsGame(), new CrapsPlayer(casinoAccount));
                        } else if (gameSelectionInput.equals("BLACKJACK")) {
                            play(new Blackjack(casinoAccount, null), new BlackjackPlayer(casinoAccount));
                        } else if (gameSelectionInput.equals("BINGO")) {
                            play(new Bingo(), new BingoPlayer(casinoAccount));
                        } else if (gameSelectionInput.equals("ROULETTE")) {
                            play(new RouletteGame(casinoAccount, null), new RoulettePlayer(casinoAccount));

                        } else if (gameSelectionInput.equals("EXIT")) {
                            break;
                        } else {
                            // TODO - implement better exception handling
                            String errorMessage = "[ %s ] is an invalid game selection";
                            throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                        }
                    }

                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")


                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ BLACKJACK ], [ BINGO ], [ ROULETTE ], [ CRAPS ], [ EXIT ]")

                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface) gameObject;
        PlayerInterface player = (PlayerInterface) playerObject;
        game.add(player);
        game.run();
    }


}

