package com.touraj.kalah.game;

/**
 * Created by toraj on 03/30/2017.
 */
public class Player {

    private String name;
    private byte playerNumber;

    public Player(String name, byte playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(byte playerNumber) {
        this.playerNumber = playerNumber;
    }
}
