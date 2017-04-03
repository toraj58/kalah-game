package com.touraj.kalah;

/**
 * Created by toraj on 03/29/2017.
 */

import com.touraj.kalah.game.GameContainer;
import com.touraj.kalah.game.KalahBoard;
import com.touraj.kalah.game.KalahGame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class KalahController {

    // inject via application.properties
    @Value("${header.message}")
    private String headerMessage;

    @RequestMapping("/game")
    public String game(Map<String, Object> model) {

        //[Touraj] :: Start New Game
        GameContainer.newGame();

        KalahGame kalahGame = GameContainer.getKalahGame();
        KalahBoard kalahBoard =  kalahGame.getKalahBoard();

        model.put("kalahBoard", kalahBoard);

        String status = "game on...";

        model.put("state", kalahGame.getState());
        model.put("turn", kalahGame.getTurn());

        model.put("status", status);
        model.put("headerMessage", headerMessage);
        return "kalah";
    }

    @RequestMapping("/play")
    public String play(Map<String, Object> model,
                       @RequestParam(value = "player", required = true) byte player,
                       @RequestParam(value = "pitnum", required = true) byte pitnum,
                       @RequestParam(value = "numstones", required = true) byte numstones
    ) {

        KalahGame kalahGame = GameContainer.getKalahGame();
        KalahBoard kalahBoard =  kalahGame.getKalahBoard();

        System.out.println("Player :: " + player);
        System.out.println("Pit Number :: " + pitnum);
        System.out.println("Num of Stones :: " + numstones);

        GameContainer.getKalahGame().play(pitnum, numstones, player);

        model.put("kalahBoard", kalahBoard);
        model.put("state", kalahGame.getState());
        model.put("turn", kalahGame.getTurn());

        model.put("headerMessage", headerMessage);
        return "kalah";
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model
    ) {

        return "index";
    }

}
