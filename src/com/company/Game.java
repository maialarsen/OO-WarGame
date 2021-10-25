package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Game {
    protected Player playerOne;
    protected Player playerTwo;
    private final ArrayList<String> winningOrder = new ArrayList<>(Arrays.asList("TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"));
    public abstract void playGame();

    public Game() {
        Deck deck = new Deck();
        ArrayList<ArrayList<Card>> hands = deck.splitDeck();
        this.playerOne = new Player(hands.get(0));
        this.playerTwo = new Player(hands.get(1));
    }

    public int checkForGreaterCard(Card playerOne, Card playerTwo) {
        if (winningOrder.indexOf(playerOne.getValue()) > winningOrder.indexOf(playerTwo.getValue()))
            return 1;
        else if (winningOrder.indexOf(playerOne.getValue()) < winningOrder.indexOf(playerTwo.getValue()))
            return -1;
        return 0;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
}