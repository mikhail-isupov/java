package ru.gb.jcore.snakegame;

import java.util.Random;

public class Food extends Cell{
    private final Random random;
    private final Snake snake;

    public Food(Snake snake) {
        super(-1, -1, Config.CELL_SIZE, Config.FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public void appear(){
        int x, y;
        do{
            x = random.nextInt(Config.CANVAS_WIDTH);
            y = random.nextInt(Config.CANVAS_HEIGHT);
        } while(snake.isInSnake(x, y));
        set(x, y);
    }

    public boolean isEaten(){
        return getX() == -1;
    }

    public void eat() {
        set(-1, -1);
    }

    public boolean isFood(int x, int y) {
        return (getX() == x && getY() == y);
    }
}
