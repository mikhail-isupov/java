package ru.gb.jcore1.main;

import ru.gb.jcore1.math.*;

/**
 * Точка входа в программу
 */
public class Main {
    public static void main(String[] args) {
        int x = 2000000000;
        int y = 0;
        IntNum result;
        result = Calc.subs(x, x);
        System.out.println(result.toString());
        result = Calc.div(x, y);
        System.out.println(result.toString());
        result = Calc.add(x, x);
        System.out.println(result.toString());
        result = Calc.mult(x, x);
        System.out.println(result.toString());
    }
}
