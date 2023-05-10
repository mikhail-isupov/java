package Exceptions;

public class IllegalFieldsNumberException extends Exception{
    public IllegalFieldsNumberException(){
        super("Некорректное число полей с данными.");
    }
}
