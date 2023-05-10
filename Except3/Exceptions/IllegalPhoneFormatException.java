package Exceptions;

public class IllegalPhoneFormatException extends Exception {
    public IllegalPhoneFormatException(){
        super("Недопустимый формат номера телефона.");
    }
}
