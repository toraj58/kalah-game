package com.touraj.kalah.game;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by toraj on 03/30/2017.
 */
public class KalahBoard {

    //[Touraj] :: Composition
    List<Pit> pits = new ArrayList<>(12);
    List<KalahStore> kalahStores = new ArrayList<>(2);

    public List<Pit> getPits() {
        return pits;
    }

    public void setPits(List<Pit> pits) {
        this.pits = pits;
    }

    public List<KalahStore> getKalahStores() {
        return kalahStores;
    }

    public void setKalahStores(List<KalahStore> kalahStores) {
        this.kalahStores = kalahStores;
    }

    public void initBoard(Player player1, Player player2)
    {

//        [Touraj] :: init player1 side
        for (byte i = 1; i <=6 ; i++) {
            Pit pit = new Pit(i, player1, (byte) 6);
            pits.add(pit);

        }

        //        [Touraj] :: init player2 side
        for (byte i = 1; i <=6 ; i++) {
            Pit pit = new Pit(i, player2, (byte) 6);
            pits.add(pit);

        }

        // [Touraj] :: Adding Kalah Store for Player 1 and Player 2
        KalahStore kalahStore1 = new KalahStore((byte) 1, player1, (byte) 0);
        KalahStore kalahStore2 = new KalahStore((byte) 2, player2, (byte) 0);

        kalahStores.add(kalahStore1);
        kalahStores.add(kalahStore2);

    }
}
