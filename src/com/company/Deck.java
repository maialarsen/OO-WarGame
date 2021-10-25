package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;
    private final int MAX_CARDS = 52;
    private final String[] VALUES = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
                                    "JACK", "QUEEN", "KING", "ACE"};
    private final String[] SUITS = {"DIAMONDS", "HEARTS", "SPADES", "CLUBS"};

    public Deck() {
        this.deck = generateDeck();
    }

    private ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < VALUES.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck.add(new Card(VALUES[i], SUITS[j]));
            }
        }

        shuffleCards(deck);
        return deck;
    }

    private void shuffleCards(ArrayList<Card> deck) {
        Random rand = new Random();
        for (int i = 0; i < MAX_CARDS; i++) {
            int randIndex = rand.nextInt(MAX_CARDS);
            Card temp = new Card(deck.get(i).getValue(), deck.get(i).getSuit());

            deck.get(i).setSuit(deck.get(randIndex).getSuit());
            deck.get(i).setValue(deck.get(randIndex).getValue());

            deck.get(randIndex).setSuit(temp.getSuit());
            deck.get(randIndex).setValue(temp.getValue());
        }
    }

    public ArrayList<ArrayList<Card>> splitDeck() {
        ArrayList<Card> playerOneHand = new ArrayList<>();
        ArrayList<Card> playerTwoHand = new ArrayList<>();

        for (int i = 0; i < MAX_CARDS; i++) {
            if (i % 2 == 0)
                playerOneHand.add(deck.get(i));
            else playerTwoHand.add(deck.get(i));
        }

        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        hands.add(playerOneHand);
        hands.add(playerTwoHand);
        return hands;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}