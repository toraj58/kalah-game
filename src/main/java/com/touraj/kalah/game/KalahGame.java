package com.touraj.kalah.game;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by toraj on 03/30/2017.
 */
public class KalahGame {

    KalahBoard kalahBoard = new KalahBoard();
    List<Player> players = new ArrayList<>(2);
    String status;
    byte turn;
    GameState state;

    public KalahGame() {

        Player player1 = new Player("Player1", (byte) 1);
        Player player2 = new Player("Player2", (byte) 2);
        initKalahGame(player1, player2);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte getTurn() {
        return turn;
    }

    public void setTurn(byte turn) {
        this.turn = turn;
    }

    public KalahBoard getKalahBoard() {
        return kalahBoard;
    }

    public void setKalahBoard(KalahBoard kalahBoard) {
        this.kalahBoard = kalahBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public void initKalahGame(Player player1, Player player2)
    {
        KalahBoard kalahBoard = new KalahBoard();
        kalahBoard.initBoard(player1, player2);
        setKalahBoard(kalahBoard);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        setPlayers(players);
        setState(GameState.notPlaying);

        //{}[Touraj] :: Let Player 1 Start the game
        setTurn((byte) 1);

        System.out.println("Init Done");

    }

    public void play(byte pitnum, byte numStones ,byte player)
    {

        int takeStonesFromPit = 0;

        if (player == 1) {
            //          [Touraj] :: Take out stones of the player1 selected pit and Minus them further in algorithm
            takeStonesFromPit = kalahBoard.getPits().get(pitnum-1).getNumberOfStones();
        } else // Player 2
        {
//            [Touraj] :: Take out stones of the player2 selected pit and Minus them further in algorithm
            takeStonesFromPit =  kalahBoard.getPits().get(pitnum+5).getNumberOfStones();

        }

        if (player == 1) {
            byte stonesOfPit = kalahBoard.getPits().get(pitnum-1).getNumberOfStones();

            int remainedMoves = stonesOfPit;

            for (int i = 1; i <= stonesOfPit ; i++, remainedMoves--) {

                if (kalahBoard.getPits().get(pitnum-1).getPitOwner().getPlayerNumber() == 1) {

                    int nextPitIndex = pitnum-1+i;
                    int lastPitIndex = nextPitIndex;

                    if (nextPitIndex == 6) {
                        // [Touraj] :: Put Stone in in Player 1 Kalah Store
                        kalahBoard.getKalahStores().get(0).setNumberOfStones(
                                (byte) (kalahBoard.getKalahStores().get(0).getNumberOfStones()+1)
                        );

                        if (i+1 > stonesOfPit) {
//                            [Touraj] :: That was last Stone so break the loop
                            break;
                        }
                        else
                        {
                            //[Toura] :: We addes pone stone to kalah so increment stones number
//                            to take effect in the next loop
                            --stonesOfPit;
                        }

                    }

                    if (nextPitIndex <= 11) {
                    kalahBoard.getPits().get(nextPitIndex)
                            .setNumberOfStones(
                                    (byte) (kalahBoard.getPits().get(nextPitIndex).getNumberOfStones()+1)
                            );
                    }
                    else
                    {
                        //[Touraj] : Circle back to another user

                        int cyclicPitIndex = nextPitIndex-12;

                        while (cyclicPitIndex >=12) {
                            cyclicPitIndex -= 12;
                        }

                        lastPitIndex = cyclicPitIndex;

                        if (cyclicPitIndex == 6) {
                            // [Touraj] :: Put Stone in in Player 1 Kalah Store
                            kalahBoard.getKalahStores().get(0).setNumberOfStones(
                                    (byte) (kalahBoard.getKalahStores().get(0).getNumberOfStones()+1)
                            );

                            if (i+1 > stonesOfPit) {
//                            [Touraj] :: That was last Stone so break the loop
                                break;
                            }
                            else
                            {
                                //[Toura] :: We addes pone stone to kalah so increment stones number
//                            to take effect in the next loop
                                --stonesOfPit;
                            }
                        }

                        kalahBoard.getPits().get(cyclicPitIndex)
                                .setNumberOfStones(
                                        (byte) (kalahBoard.getPits().get(cyclicPitIndex).getNumberOfStones()+1)
                                );
                    }

                    //                [Touraj] :: Last Stone place and decide a bonus turn, cumulate player and opposite stones or
//                Give turn to the other player

                    if (i == stonesOfPit) {
                        // [Touraj] :: This is the last Stone of this player in this round decide what to do next


                        int numOfStonesInLastPit = kalahBoard.getPits().get(lastPitIndex).getNumberOfStones();

                        if (numOfStonesInLastPit == 1
                                && kalahBoard.getPits().get(lastPitIndex).getPitOwner().getPlayerNumber() == 1) {
//                            [Touraj] :: pit was previously empty so do cumulate player stones and oppiste side
//                            and Place to Player's Kalah

                            int KalahCurrentNumOfStones= kalahBoard.getKalahStores().get(0).getNumberOfStones();
                            int oppsiteSideStones= kalahBoard.getPits()
                                    .get(lastPitIndex + (11 - (2*lastPitIndex))).getNumberOfStones();

                            //[Touraj] :: Following would be always 1 in this type of game
//                            Nut I get it for future extensions
                            int lastIndexStones= kalahBoard.getPits().get(lastPitIndex).getNumberOfStones();

                            kalahBoard.getKalahStores().get(0)
                                    .setNumberOfStones((byte) (KalahCurrentNumOfStones + oppsiteSideStones + lastIndexStones));

                            //[Touraj] :: Stones cumulated in Player's Kalah so deplete player pit and opposite pit
                            kalahBoard.getPits().get(lastPitIndex).setNumberOfStones((byte) 0);
                            //[Touraj] :: Empty opposite Pit
                            kalahBoard.getPits().get(lastPitIndex + (11 - (2*lastPitIndex))).setNumberOfStones((byte) 0);
                        }

                        //[Touraj] :: Give Turn to player 2
                        setTurn((byte) 2);
                    }

                }
            }
            //[Touraj] :: take out intial number of stones of the pit and minus them from final cumulated stones
            kalahBoard.getPits().get(pitnum-1).setNumberOfStones((byte) (kalahBoard.getPits().get(pitnum-1).getNumberOfStones() - takeStonesFromPit));

        } else // Player 2 Move
        {
            byte stonesOfPit = kalahBoard.getPits().get(pitnum+5).getNumberOfStones();

            int remainedMoves = stonesOfPit;

            for (int i = 1; i <= stonesOfPit ; i++, remainedMoves--) {
                if (kalahBoard.getPits().get(pitnum+5).getPitOwner().getPlayerNumber() == 2) {

                    int nextPitIndex = pitnum+5+i;
                    int lastPitIndex = nextPitIndex;

                    if (nextPitIndex <= 11) {
                        kalahBoard.getPits().get(nextPitIndex)
                                .setNumberOfStones(
                                        (byte) (kalahBoard.getPits().get(nextPitIndex).getNumberOfStones()+1)
                                );
                    }
                    else
                    {
                        //[Touraj] : Circle back to another user

                        int cyclicPitIndex = nextPitIndex-12;

                        while (cyclicPitIndex >=12) {
                            cyclicPitIndex -= 12;
                        }

                        lastPitIndex = cyclicPitIndex;

                        if (cyclicPitIndex == 0) {
                            // [Touraj] :: Put Stone in in Player 2 Kalah Store
                            kalahBoard.getKalahStores().get(1).setNumberOfStones(
                                    (byte) (kalahBoard.getKalahStores().get(1).getNumberOfStones()+1)
                            );

                            if (i+1 > stonesOfPit) {
//                            [Touraj] :: That was last Stone so break the loop
                                break;
                            }
                            else
                            {
                                //[Toura] :: We addes pone stone to kalah so increment stones number
                                //to take effect in the next loop
                                --stonesOfPit;
                            }
                        }

                        kalahBoard.getPits().get(cyclicPitIndex)
                                .setNumberOfStones(
                                        (byte) (kalahBoard.getPits().get(cyclicPitIndex).getNumberOfStones()+1)
                                );
                    }

                    //                [Touraj] :: Last Stone place and decide a bonus turn, cumulate player and opposite stones or
                    //                Give turn to the other player

                    if (i == stonesOfPit) {
                        // [Touraj] :: This is the last Stone of this player in this round decide what to do next

                        int numOfStonesInLastPit = kalahBoard.getPits().get(lastPitIndex).getNumberOfStones();

                        if (numOfStonesInLastPit == 1
                                && kalahBoard.getPits().get(lastPitIndex).getPitOwner().getPlayerNumber() == 2) {
//                            [Touraj] :: pit was previously empty so do cumulate player stones and oppiste side
//                            and Place to Player's Kalah

                            int KalahCurrentNumOfStones= kalahBoard.getKalahStores().get(1).getNumberOfStones();
                            int oppsiteSideStones= kalahBoard.getPits()
                                    .get(lastPitIndex - (11 - (2 * (11 - lastPitIndex)))).getNumberOfStones();

                            //[Touraj] :: Following would be always 1 in this type of game
//                            Nut I get it for future extensions
                            int lastIndexStones= kalahBoard.getPits().get(lastPitIndex).getNumberOfStones();

                            kalahBoard.getKalahStores().get(1)
                                    .setNumberOfStones((byte) (KalahCurrentNumOfStones + oppsiteSideStones + lastIndexStones));

                            //[Touraj] :: Stones cumulated in Player's Kalah so deplete player pit and opposite pit
                            kalahBoard.getPits().get(lastPitIndex).setNumberOfStones((byte) 0);
                            //[Touraj] :: Empty opposite Pit
                            kalahBoard.getPits().get(lastPitIndex - (11 - (2 * (11 - lastPitIndex)))).setNumberOfStones((byte) 0);
                        }

                        //[Touraj] :: Give Turn to player 1
                        setTurn((byte) 1);

                    }

                }
            }

            //[Touraj] :: take out intial number of stones of the pit and minus them from final cumulated stones
            kalahBoard.getPits().get(pitnum+5).setNumberOfStones((byte) (kalahBoard.getPits().get(pitnum+5).getNumberOfStones() - takeStonesFromPit));

        }

//        [touraj] :: By Default we assume game is finished but we change this as the following
        boolean isGameFinished = true;

        for (int i = 0; i <=5 ; i++) {

//            [Touraj] :: Check to see if all player1's pits are empty so finish Game
            int stonesNum = kalahBoard.getPits().get(i).getNumberOfStones();

            if (stonesNum > 0 ) {
                isGameFinished = false;
                break;
            }

        }

        if (!isGameFinished) {
            //[Touraj] :: Againg we assume it finished otherwise contrary
            isGameFinished = true;
            for (int i = 6; i <=11 ; i++) {

//            [Touraj] :: Check to see if all player2's pits are empty so finish Game
                int stonesNum = kalahBoard.getPits().get(i).getNumberOfStones();

                if (stonesNum > 0 ) {
                    isGameFinished = false;
                    break;
                }

            }
        }

        if (isGameFinished) {

            setStatus("gamefinish");
            setState(GameState.finished);

            // [Touraj] :: Find who wins the Game or Game is a Draw
            calculateWinner();

            //[Touraj] :: Poision Pill Shutdown Technique ... hahaha
            //[Touraj] :: That locks board and prevent further actions from Players
            setTurn((byte) 66);

            System.out.println("**************************************");
            System.out.println("**                                  **");
            System.out.println("**         Game is Finished         **");
            System.out.println("**                                  **");
            System.out.println("**************************************");

            //[Touraj] :: Game Integrity Check :: For Debugging :: Can be Omitted
            System.out.println("sumOfStonesofAllpits() :: " + sumOfStonesofAllpits());

        }
        else
        {
            setState(GameState.playing);

            //[Touraj] :: Game Integrity Check :: For Debugging :: Can be Omitted
            System.out.println(" >>>>>>>>>>>   sumOfStonesofAllpits() :: " + sumOfStonesofAllpits());

        }

        }

    private void calculateWinner() {

        int stonesOfPlayer1 = 0;
        int stonesOfPlayer2 = 0;

        for (int i = 0; i <=5 ; i++) {

            stonesOfPlayer1 += kalahBoard.getPits().get(i).getNumberOfStones();

        }

        stonesOfPlayer1 += kalahBoard.getKalahStores().get(0).getNumberOfStones();

        System.out.printf("Player 1 totally has %d stones\n", stonesOfPlayer1);

        for (int i = 6; i <=11 ; i++) {
            stonesOfPlayer2 += kalahBoard.getPits().get(i).getNumberOfStones();

        }

        stonesOfPlayer2 += kalahBoard.getKalahStores().get(1).getNumberOfStones();
        System.out.printf("Player 2 totally has %d stones\n", stonesOfPlayer2);

        if (stonesOfPlayer1 == stonesOfPlayer2) {
            setState(GameState.draw);
        }
        else if (stonesOfPlayer1 > stonesOfPlayer2)
        {
            setState(GameState.player1Win);
        }
        else
        {
            setState(GameState.player2Win);
        }

    }

    private int sumOfStonesofAllpits() {

        int sum = 0;

        for (Pit pit : kalahBoard.getPits()) {

            sum += pit.getNumberOfStones();

        }

        sum += kalahBoard.getKalahStores().get(0).getNumberOfStones();
        sum += kalahBoard.getKalahStores().get(1).getNumberOfStones();

        return sum;
    }
}