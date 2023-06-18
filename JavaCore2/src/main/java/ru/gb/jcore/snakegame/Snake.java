package ru.gb.jcore.snakegame;

import java.awt.*;
import java.util.LinkedList;


public class Snake {
    private final LinkedList<Cell> snake;
    private int direction;
    private Food food;
    private Poison poison;
    private boolean isSnakeAlive;

    public Snake(int x, int y, int length, int direction) {
        this.snake = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            this.snake.add(new Cell(x - i, y, Config.CELL_SIZE, Config.SNAKE_COLOR));
        }
        this.direction = direction;
        this.isSnakeAlive = true;
    }

    public void setDirection(int direction) {
        if ((direction >= Config.KEY_LEFT) && (direction <= Config.KEY_DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public int size() {
        return this.snake.size();
    }

    public void move() {
        int x = this.snake.getFirst().getX();
        int y = this.snake.getFirst().getY();
        switch (this.direction) {
            case Config.KEY_LEFT:
                x--;
                if (x < 0)
                    x = Config.CANVAS_WIDTH - 1;
                break;
            case Config.KEY_RIGHT:
                x++;
                if (x == Config.CANVAS_WIDTH)
                    x = 0;
                break;
            case Config.KEY_UP:
                y--;
                if (y < 0)
                    y = Config.CANVAS_HEIGHT - 1;
                break;
            case Config.KEY_DOWN:
                y++;
                if (y == Config.CANVAS_HEIGHT)
                    y = 0;
                break;
        }
        if (isInSnake(x, y) || poison.isPoison(x, y)) {           // if the snake crosses itself or if it eats poison
            this.isSnakeAlive = false;
            return;
        }
        this.snake.addFirst(new Cell(x, y, Config.CELL_SIZE, Config.SNAKE_COLOR)); // new head of snake
        if (this.food.isFood(x, y)) {
            this.food.eat();
        } else {
            this.snake.removeLast();
        }
    }

    public void paint(Graphics2D g) {
        for (Cell cell : this.snake) {
            cell.paint(g);
        }
    }

    public boolean isInSnake(int x, int y) {
        for (Cell cell : this.snake) {
            if ((cell.getX() == x) && (cell.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }

    public boolean isAlive() {
        return this.isSnakeAlive;
    }
}
