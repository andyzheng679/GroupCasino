package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    //void add(PlayerInterface player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    //void remove(PlayerInterface player);

    void run();

    boolean getWinner();


    void add(PlayerInterface player);

}
