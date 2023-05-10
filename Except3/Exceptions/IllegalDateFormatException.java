package Exceptions;

public class IllegalDateFormatException extends Exception {
    public IllegalDateFormatException(){
        super("Недопустимый формат даты.");
    }
}
