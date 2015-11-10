package com.ua.classes;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Game {
    AbstractPlayer[] players = new Player[2];

    public void newGamePlayerVSPlayer() {
        players = new AbstractPlayer[]{new Player(), new Player()};
        players[0].createFields();
        players[1].setFields(players[0].getOprtField(), players[0].getMyField());

        int switcher = 0;
        while (!players[switcher].gameOver()) {
            players[switcher].doMove();
            switcher = this.moveSwitcher(switcher);
        }
    }

    private int moveSwitcher(int i) {
        if (i == 0) return 1;
        return 0;
    }
}
