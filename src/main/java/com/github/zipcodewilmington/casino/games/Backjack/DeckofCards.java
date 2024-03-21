package com.github.zipcodewilmington.casino.games.Backjack;

import java.util.Collections;
import java.util.Stack;


public class DeckofCards {
    private Stack<Cards> deck;

    //Constructor, when you create an instance of it, create new deck
    //add cards to the stack, then shuffle the deck
    public DeckofCards() {
        deck = new Stack<>();


        for (Cards card : Cards.values()) {
            deck.push(card);

        }
        Collections.shuffle(deck);
    }

    //draw a card from shuffled deck
    public Cards drawCard() {
        if (!deck.isEmpty()) {
            return deck.pop();
        } else {
            throw new IllegalStateException("Cannot draw from an empty deck.");
        }
    }

    //clear the deck, and add new cards to  the stack, then shuffle, should be mainly used
    //if player wants to play again
    public void resetDeck(){
        deck.clear();

        for(Cards card : Cards.values()) {
            deck.push(card);
        }

        Collections.shuffle(deck);
    }


}

