package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberGuessGameTest {
    @Test // testing for random num
    public void testGetRandomNumber() {
        int number = NumberGuessGame.getRandomNumber();

        assertTrue(number >= 0 && number <= 10);
    }
}
