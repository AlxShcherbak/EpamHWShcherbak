package com.ua.classes;

import java.util.Random;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Computer extends AbstractPlayer {
    private enum Way {
        NoN, RIGHT, LEFT, UP, DOWN;
    }

    private Random random = new Random();
    private int[] lastMove = new int[]{-1, -1};
    private int[] lastShot = new int[]{-1, -1};
    private Way way = Way.NoN;

    @Override
    void doMove() {
        int moveX, moveY;
        boolean[] shot = new boolean[2];
        if (lastShot[0] == -1) {
            do {
                lastMove[0] = random.nextInt(10);
                lastMove[1] = random.nextInt(10);
            } while (fields[1].cellShoted(lastMove[0], lastMove[1]));
            shot = fields[1].shot(lastMove[0], lastMove[1]);
        } else {
            if (way == Way.NoN) {
                if (lastShot[0] < 9) way = Way.RIGHT;
                else way = Way.LEFT;
            }
            if (way == Way.RIGHT || (way == Way.LEFT && lastShot[0] == 0)) {
                do {
                    lastMove[0] = lastShot[0] + 1;
                    lastMove[1] = lastShot[1];
                } while (fields[1].cellShoted(lastMove[0], lastMove[1]));
                shot = fields[1].shot(lastMove[0], lastMove[1]);
                if (!shot[0]) way = Way.LEFT;
            } else if (way == Way.LEFT || (way == Way.RIGHT && lastShot[0] == 9)) {
                do {
                    lastMove[0] = lastShot[0] - 1;
                    lastMove[1] = lastShot[1];
                } while (fields[1].cellShoted(lastMove[0], lastMove[1]));
                shot = fields[1].shot(lastMove[0], lastMove[1]);
                if (!shot[0]) way = Way.UP;
            } else if (way == Way.UP || (way == Way.DOWN && lastShot[1] == 9)) {
                do {
                    lastMove[0] = lastShot[0];
                    lastMove[1] = lastShot[1] - 1;
                } while (fields[1].cellShoted(lastMove[0], lastMove[1]));
                shot = fields[1].shot(lastMove[0], lastMove[1]);
                if (!shot[0]) way = Way.DOWN;
            } else if (way == Way.DOWN || (way == Way.UP && lastShot[1] == 0)) {
                do {
                    lastMove[0] = lastShot[0];
                    lastMove[1] = lastShot[1] + 1;
                } while (fields[1].cellShoted(lastMove[0], lastMove[1]));
                shot = fields[1].shot(lastMove[0], lastMove[1]);
                if (!shot[0]) way = Way.NoN;
            }

        }

        if (shot[0] && !shot[1]) {  //карабыль подбит но не потоплен
            lastShot[0] = lastMove[0];
            lastShot[1] = lastMove[1];
            doMove();
        } else if (shot[0] && shot[1]) {  //карабыль подбит и потоплен
            lastShot[0] = -1;
            lastShot[1] = -1;
            way = Way.NoN;
            doMove();
        }
    }
}
