package ru.gb.jcore.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс для отображения игрового поля и работы с клавиатурой
 */
public class View extends JFrame {
    final private Canvas canvas;
    final private Snake snake;
    final private Food food;
    final private Poison poison;
    public View(Snake snake, Food food, Poison poison){
        setTitle(Config.TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.snake = snake;
        this.food = food;
        this.poison = poison;
        this.canvas = new Canvas();
        this.canvas.setBackground(Color.WHITE);
        this.canvas.setPreferredSize(new Dimension(Config.CELL_SIZE * Config.CANVAS_WIDTH,
                Config.CELL_SIZE * Config.CANVAS_HEIGHT));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });
        add(this.canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void repaint(){
        this.canvas.repaint();
    }

    public void finish(){
        setTitle(Config.GAME_OVER_MSG);
    }
    class Canvas extends JPanel {    // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            poison.paint(g2D);
        }
    }

}
