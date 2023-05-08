package Exceptions;

public class IllegalNameException extends Exception {
    public IllegalNameException(){
        super("Некорректное полное имя.");
    }
}
