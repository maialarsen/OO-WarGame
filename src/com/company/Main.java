package com.company;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage error: need game mode [1,2]");
            System.exit(1);
        }

        int gameMode = Integer.parseInt(args[0]);
        Game gm = null;

        if (gameMode == 1) {
            if (args[1] == null) {
                System.out.println("Usage error: need number of rounds for game mode 1");
                System.exit(1);
            }
            int numRounds = Integer.parseInt(args[1]);
            gm = new GameMode1(numRounds);
        }
        else if (gameMode == 2)
            gm = new GameMode2();
        else
            System.exit(1);

        gm.playGame();
    }
}