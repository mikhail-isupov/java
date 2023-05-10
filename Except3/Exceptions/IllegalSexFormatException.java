package Exceptions;

public class IllegalSexFormatException extends Exception{
    public IllegalSexFormatException(){
        super("Недопустимое обозначение пола.");
    }
}
