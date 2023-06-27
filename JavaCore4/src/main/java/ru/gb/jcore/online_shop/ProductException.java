package ru.gb.jcore.online_shop;

/**
 * Исключение при отсутствующем товаре
 */
public class ProductException extends Exception {
    public ProductException() {
        super("Несуществующий товар");
    }

    public ProductException(String productName) {
        super(String.format("Несуществующий товар %s", productName));
    }
}
