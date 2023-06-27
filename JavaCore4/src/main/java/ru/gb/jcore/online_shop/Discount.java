package ru.gb.jcore.online_shop;

import java.util.Random;

/**
 * Перечисление со скидками и методом для получения случайной скидки
 */
public enum Discount {
    ZERO(0),
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20);
    private final int discount;
    Discount(int discount){
        this.discount = discount;
    }
    public int getDiscount(){
        return discount;
    }

    public static int getRandomDiscount(){
        Random rnd = new Random();
        Discount[] discounts = values(); // Получаем массив скидок Discount
        return discounts[rnd.nextInt(discounts.length)].getDiscount(); // Берем случайную скидку из массива и извлекаем ее значение
    }


}
