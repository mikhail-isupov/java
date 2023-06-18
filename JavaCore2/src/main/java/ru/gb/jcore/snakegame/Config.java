package ru.gb.jcore.snakegame;

import java.awt.*;

/**
 * SnakeGame config file
 */
public class Config {
    final static String TITLE_OF_PROGRAM = "Classic Game Snake";
    final static String GAME_OVER_MSG = "GAME OVER";
    final static int CELL_SIZE = 20;           // size of cell in pix
    final static int CANVAS_WIDTH = 30;        // width in cells
    final static int CANVAS_HEIGHT = 25;       // height in cells
    final static Color SNAKE_COLOR = Color.darkGray;
    final static Color FOOD_COLOR = Color.green;
    final static Color POISON_COLOR = Color.red;
    final static int KEY_LEFT = 37;            // codes
    final static int KEY_UP = 38;              //   of
    final static int KEY_RIGHT = 39;           //   cursor
    final static int KEY_DOWN = 40;            //   keys
    final static int START_SNAKE_SIZE = 5;            // initialization data
    final static int START_SNAKE_X = CANVAS_WIDTH / 2;  //   for
    final static int START_SNAKE_Y = CANVAS_HEIGHT / 2; //   snake
    final static int SNAKE_DELAY = 150;               // snake delay in milliseconds
}
