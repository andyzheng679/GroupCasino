import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.Backjack.Blackjack;
import com.github.zipcodewilmington.casino.games.Backjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.Backjack.Cards;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class BlackjackTest {

    private Blackjack blackjack;
    private BlackjackPlayer player;

    @Before
    public void setUp() {
        // Create dummy casino accounts for testing
        CasinoAccount testPlayerAccount = new CasinoAccount("test1", "pass");
        CasinoAccount testDealerAccount = new CasinoAccount("text2", "pass");


        blackjack = new Blackjack(testPlayerAccount, testDealerAccount);

        player = new BlackjackPlayer(testPlayerAccount);
    }

    @Test
    public void getWinner_PlayerBusts_DealerWins() {

        ArrayList<Cards> playerHand = new ArrayList<>();
        playerHand.add(Cards.TEN);
        playerHand.add(Cards.TEN);
        playerHand.add(Cards.TWO); // This makes 22, a bust for the player
        blackjack.player.playerHand = playerHand;

        ArrayList<Cards> dealerHand = new ArrayList<>();
        dealerHand.add(Cards.NINE);
        dealerHand.add(Cards.EIGHT); // Dealer has >= 17
        blackjack.dealer.playerHand = dealerHand;

        // Act
        boolean result = blackjack.getWinner();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void getWinner_PlayerWins_DealerBust() {
        ArrayList<Cards> playerHand = new ArrayList<>();
        playerHand.add(Cards.TEN);
        playerHand.add(Cards.TEN); // Player has 20
        blackjack.player.playerHand = playerHand;

        // Set up dealer hand to simulate a bust
        ArrayList<Cards> dealerHand = new ArrayList<>();
        dealerHand.add(Cards.NINE);
        dealerHand.add(Cards.SIX);
        dealerHand.add(Cards.SEVEN); // Dealer busts with 22
        blackjack.dealer.playerHand = dealerHand;

        boolean result = blackjack.getWinner();

        Assert.assertTrue(result);
    }

    @Test
    public void sumOfHand() {

        player.playerHand = new ArrayList<>();
        player.playerHand.add(Cards.TEN);
        player.playerHand.add(Cards.TEN);

        Assert.assertEquals(20,player.sumOfHand());
    }

    @Test
    public void sumOfHand2() {

        player.playerHand = new ArrayList<>();
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);
        player.playerHand.add(Cards.ACE);

        Assert.assertEquals(19,player.sumOfHand());
    }

    @Test
    public void testHitOrStandStand() {
        String input = "stand\n"; // User input simulated as "stand"
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes())); // Create a Scanner that uses the input
        BlackjackPlayer player = new BlackjackPlayer(scanner); // Pass the scanner to the player

        // Execute & Assert
        Assert.assertFalse(player.hitOrStand(scanner));
    }

    @Test
    public void testHitOrStandHit() {
        String input = "hit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        BlackjackPlayer player = new BlackjackPlayer(scanner);

        // Execute & Assert
        Assert.assertTrue(player.hitOrStand(scanner));
    }

    @Test
    public void testDoubleDownYes() {
        String simulatedUserInput = "Y\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        BlackjackPlayer player = new BlackjackPlayer(new Scanner(in));

        Assert.assertTrue(player.doubleDown());
    }

    @Test
    public void testDoubleDownNo() {
        String simulatedUserInput = "N\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        BlackjackPlayer player = new BlackjackPlayer(new Scanner(in));

        Assert.assertFalse(player.doubleDown());
    }

    @Test
    public void testSplitSplit() {

        BlackjackPlayer player = new BlackjackPlayer(new Scanner(new ByteArrayInputStream("Y\n".getBytes())));
        player.playerHand.add(Cards.TEN);
        player.playerHand.add(Cards.TEN);

        Assert.assertTrue(player.split());
        Assert.assertEquals(1, player.playerHand.size());
        Assert.assertEquals(1, player.splitHand.size());
    }

    @Test
    public void testSplitNoSplit() {

        BlackjackPlayer player = new BlackjackPlayer(new Scanner(new ByteArrayInputStream("N\n".getBytes())));
        player.playerHand.add(Cards.EIGHT);
        player.playerHand.add(Cards.EIGHT);


        Assert.assertFalse(player.split());
    }

    @Test
    public void testSplitCannotSplit() {

        BlackjackPlayer player = new BlackjackPlayer(new Scanner(System.in));
        player.playerHand.add(Cards.TEN);
        player.playerHand.add(Cards.EIGHT);

        Assert.assertFalse(player.split());
    }

    @Test
    public void testSurrenderYes() {

        String simulatedUserInput = "Y\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        BlackjackPlayer player = new BlackjackPlayer(new Scanner(in));

        Assert.assertTrue(player.surrender());
    }

    @Test
    public void testSurrenderNo() {

        String simulatedUserInput = "N\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        BlackjackPlayer player = new BlackjackPlayer(new Scanner(in));

        Assert.assertFalse(player.surrender());
    }

}
