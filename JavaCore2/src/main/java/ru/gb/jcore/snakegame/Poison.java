package ru.gb.jcore.snakegame;

import java.util.Random;

public class Poison extends Cell {
    private final Random random;
    private final Snake snake;

    public Poison(Snake snake) {
        super(-1, -1, Config.CELL_SIZE, Config.POISON_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(Config.CANVAS_WIDTH);
            y = random.nextInt(Config.CANVAS_HEIGHT);
        } while (this.snake.isInSnake(x, y));
        set(x, y);
    }
/*
    public boolean isEaten(){
        return getX() == -1;
    }

    public void eat() {
        set(-1, -1);
    }

*/

    public boolean isPoison(int x, int y) {
        return (getX() == x && getY() == y);
    }
}
