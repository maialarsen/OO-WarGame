package com.company;

import java.util.ArrayList;

public class GameMode1 extends Game{
    private int numRounds;

    public GameMode1(int numRounds) {
        this.numRounds = numRounds;
    }

    @Override
    public void playGame() {
        while (numRounds > 0 && playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0) {
            Card playerOneCard = playerOne.playCard();
            Card playerTwoCard = playerTwo.playCard();

            System.out.println("Player 1 plays " + playerOneCard.getValue() + " of " + playerOneCard.getSuit());
            System.out.println("Player 2 plays " + playerTwoCard.getValue() + " of " + playerTwoCard.getSuit());

            int winner = checkForGreaterCard(playerOneCard, playerTwoCard);
            if (winner == 1) {
                System.out.println("Player 1 wins the round");
                playerOne.getHand().add(playerOneCard);
                playerOne.getHand().add(playerTwoCard);
            }
            else if (winner == -1) {
                System.out.println("Player 2 wins the round");
                playerTwo.getHand().add(playerOneCard);
                playerTwo.getHand().add(playerTwoCard);
            }
            else {
                ArrayList<Card> playedCards = new ArrayList<>();
                playedCards.add(playerOneCard);
                playedCards.add(playerTwoCard);

                while (winner == 0 && playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0) {
                    System.out.println("**WAR!**");
                    playerOneCard = playerOne.playCard();
                    playerTwoCard = playerTwo.playCard();
                    playedCards.add(playerOneCard);
                    playedCards.add(playerTwoCard);

                    System.out.println("Player 1 plays " + playerOneCard.getValue() + " of " + playerOneCard.getSuit());
                    System.out.println("Player 2 plays " + playerTwoCard.getValue() + " of " + playerTwoCard.getSuit());
                    winner = checkForGreaterCard(playerOneCard, playerTwoCard);
                }

                if (winner == 1) {
                    System.out.println("Player 1 wins this round");
                    playerOne.getHand().addAll(playedCards);
                }
                else if (winner == -1) {
                    System.out.println("Player 2 wins this round");
                    playerTwo.getHand().addAll(playedCards);
                }
            }

            playerOne.setScore(playerOne.getHand().size());
            playerTwo.setScore(playerTwo.getHand().size());
            System.out.println("Player 1 has a score of " + playerOne.getScore());
            System.out.println("Player 2 has a score of " + playerTwo.getScore());

            numRounds--;
        }

        if (playerOne.getScore() > playerTwo.getScore())
            System.out.println("Player 1 wins the game!");
        else if (playerOne.getScore() < playerTwo.getScore())
            System.out.println("Player 2 wins the game!");
        else
            System.out.println("Tie Game!");
    }
}