package com.touraj.kalah.game;

/**
 * Created by toraj on 03/30/2017.
 */
public class GameContainer {

    private static KalahGame kalahGame = null;

    public static KalahGame getKalahGame() {
        return kalahGame;
    }

    public static void setKalahGame(KalahGame kalahGame) {
        GameContainer.kalahGame = kalahGame;
    }

    public static void newGame()
    {
        kalahGame = new KalahGame();
    }
}
