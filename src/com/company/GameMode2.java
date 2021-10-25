package com.company;

public class GameMode2 extends Game{
    @Override
    public void playGame() {
        int plays = playerOne.getHand().size();
        for (int i = 0; i < plays; i++) {
            int pointsToAdd = 2;
            Card playerOneCard = playerOne.playCard();
            Card playerTwoCard = playerTwo.playCard();

            System.out.println("Player 1 plays " + playerOneCard.getValue() + " of " + playerOneCard.getSuit());
            System.out.println("Player 2 plays " + playerTwoCard.getValue() + " of " + playerTwoCard.getSuit());

            int winner = checkForGreaterCard(playerOneCard, playerTwoCard);
            if (winner == 1) {
                System.out.println("Player 1 wins the round");
                playerOne.setScore(playerOne.getScore() + pointsToAdd);
            } else if (winner == -1) {
                System.out.println("Player 2 wins the round");
                playerTwo.setScore(playerTwo.getScore() + pointsToAdd);
            } else {
                while (winner == 0 && playerOne.getHand().size() > 0 && playerTwo.getHand().size() > 0) {
                    System.out.println("**WAR!**");
                    pointsToAdd += 2;
                    i++;

                    playerOneCard = playerOne.playCard();
                    playerTwoCard = playerTwo.playCard();
                    System.out.println("Player 1 plays " + playerOneCard.getValue() + " of " + playerOneCard.getSuit());
                    System.out.println("Player 2 plays " + playerTwoCard.getValue() + " of " + playerTwoCard.getSuit());

                    winner = checkForGreaterCard(playerOneCard, playerTwoCard);
                }
                if (winner == 1) {
                    System.out.println("Player 1 wins the round");
                    playerOne.setScore(playerOne.getScore() + pointsToAdd);
                } else if (winner == -1) {
                    System.out.println("Player 2 wins the round");
                    playerTwo.setScore(playerTwo.getScore() + pointsToAdd);
                }
            }
            System.out.println("Player 1 has a score of " + playerOne.getScore());
            System.out.println("Player 2 has a score of " + playerTwo.getScore());
        }

        if (playerOne.getScore() > playerTwo.getScore())
            System.out.println("Player 1 wins the game!");
        else if (playerOne.getScore() < playerTwo.getScore())
            System.out.println("Player 2 wins the game!");
        else
            System.out.println("Tie Game!");
    }
}