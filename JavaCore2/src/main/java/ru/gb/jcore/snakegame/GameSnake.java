package ru.gb.jcore.snakegame;

import javax.swing.*;

public class GameSnake extends JFrame {
    final private View view;                   // An object for rendering (drawing)
    final private Snake snake;                     // declare a snake object
    final private Food food;                       // declare a food object
    final private Poison poison;                   // declare a poison object

    public static void main(String[] args) {
        new GameSnake().game();
    }

    public GameSnake() {
        snake = new Snake(
                Config.START_SNAKE_X,
                Config.START_SNAKE_Y,
                Config.START_SNAKE_SIZE,
                Config.KEY_RIGHT);

        food = new Food(snake);
        poison = new Poison(snake);
        snake.setFood(food);
        snake.setPoison(poison);
        view = new View(snake, food, poison);
    }

    private void game() {
        while (snake.isAlive()) {
            snake.move();
            if (food.isEaten()) {
                food.appear();
                poison.appear();
            }
            view.repaint();
            sleep(Config.SNAKE_DELAY);
        }
        view.finish();
    }

    private void sleep(long ms) {    // method for suspending
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
