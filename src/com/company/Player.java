package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int score;

    public Player(ArrayList<Card> hand) {
        this.hand = hand;
        this.score = 0;
    }

    public Card playCard() {
        return this.hand.remove(0);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}