package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.Roulette.Pocket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PocketTest {
    @Test // testing number and color of pocket
    public void testPocket() {
        Pocket pocket = new Pocket(1, "Red");
        assertEquals(1, pocket.getNumber());
        assertEquals("Red", pocket.getColor());
    }
}
