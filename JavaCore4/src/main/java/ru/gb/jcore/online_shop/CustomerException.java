package ru.gb.jcore.online_shop;

/**
 * Исключение при отсутствующем покупателе
 */
public class CustomerException extends Exception{
    public CustomerException(){
        super("Несуществующий покупатель");
    }
    public CustomerException(String name, String surname, Gender sex, int age){
        super(String.format("Несуществующий покупатель %s %s %s возраст %d", name, surname, sex, age));
    }
}

