package ru.gb.jcore1.math;

/**
 * Класс, содержащий методы для выполнения арифметических операций над двумя целочисленными аргументами
 */
public class Calc {
    /**
     * Метод для сложения двух целочисленных аргументов
     *
     * @param x первый целочисленный аргумент типа Int
     * @param y второй целочисленный аргумент типа Int
     * @return Data обьект IntNum
     */
    public static IntNum add(int x, int y) {
        int result = 0;
        try {
            result = x + y;
        } catch (ArithmeticException e) {
            return new IntNum(x, y, "+");
        }
        return new IntNum(x, y, "+", result);
    }

    /**
     * Метод для вычитания двух целочисленных аргументов
     *
     * @param x первый целочисленный аргумент типа Int
     * @param y второй целочисленный аргумент типа Int
     * @return Data обьект IntNum
     */
    public static IntNum subs(int x, int y) {
        int result = 0;
        try {
            result = x - y;
        } catch (ArithmeticException e) {
            return new IntNum(x, y, "-");
        }
        return new IntNum(x, y, "-", result);
    }

    /**
     * Метод для деления двух целочисленных аргументов
     *
     * @param x первый целочисленный аргумент типа Int
     * @param y второй целочисленный аргумент типа Int
     * @return Data обьект IntNum
     */
    public static IntNum div(int x, int y) {
        int result = 0;
        try {
            result = x / y;
        } catch (ArithmeticException e) {
            return new IntNum(x, y, "/");
        }
        return new IntNum(x, y, "/", result);
    }

    /**
     * Метод для умножения двух целочисленных аргументов
     *
     * @param x первый целочисленный аргумент типа Int
     * @param y второй целочисленный аргумент типа Int
     * @return Data обьект IntNum
     */
    public static IntNum mult(int x, int y) {
        int result = 0;
        try {
            result = x * y;
        } catch (ArithmeticException e) {
            return new IntNum(x, y, "*");
        }
        return new IntNum(x, y, "*", result);
    }
}
