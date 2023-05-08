package Exceptions;

public class NonExistentDateException extends Exception{
    public NonExistentDateException(String date){
        super("Несуществуюшая дата: " + date);
    }
}
