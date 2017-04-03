package com.touraj.kalah.game;

/**
 * Created by toraj on 03/30/2017.
 */
public class KalahStore {

    private byte kalahStoreNumber;
    private byte numberOfStones;
    private Player pitOwner;

    public KalahStore(byte kalahStoreNumber, Player pitOwner, byte numberOfStones) {
        this.kalahStoreNumber = kalahStoreNumber;
        this.pitOwner = pitOwner;
        this.numberOfStones = numberOfStones;
    }

    public byte getKalahStoreNumber() {
        return kalahStoreNumber;
    }

    public void setKalahStoreNumber(byte kalahStoreNumber) {
        this.kalahStoreNumber = kalahStoreNumber;
    }

    public Player getPitOwner() {
        return pitOwner;
    }

    public void setPitOwner(Player pitOwner) {
        this.pitOwner = pitOwner;
    }

    public byte getNumberOfStones() {
        return numberOfStones;
    }

    public void setNumberOfStones(byte numberOfStones) {
        this.numberOfStones = numberOfStones;
    }
}
