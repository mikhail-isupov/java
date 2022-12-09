//Калькулятор
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double x, y, result;
        String operation;
        
        do {
        System.out.println("Введите первое число: ");
        x = keyboard.nextDouble();
        System.out.println("Введите второе число: ");
        y = keyboard.nextDouble();
        System.out.println("Введите операцию (*,/,+,-) или команду quit для выхода ");
        operation = keyboard.next();
        switch(operation) {
            case "+": result = x + y; break;
            case "-": result = x - y; break;
            case "*": result = x * y; break;
            case "/": result = x / y; break;
            default: result = 0;
        } 
        System.out.println(result);
        } while (! operation.equals("quit"));
        keyboard.close();
    
    }
}
