package ru.gb.jcore.online_shop;

/**
 * Исключение при некорректном числе товара
 */
public class AmountException extends Exception {
    public AmountException() {
        super("Некорректное количество товара");
    }

    public AmountException(int amount) {
        super(String.format("Некорректное количество товара %d", amount));
    }

}
