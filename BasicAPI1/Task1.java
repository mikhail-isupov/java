// Расчет суммы арифметической прогрессии и факториала.
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        
        System.out.println("n = ?");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        keyboard.close();
        String outputString = String.format("Сумма арифметической прогрессии от 1 до %d = %d", n, arithProgr(n));
        System.out.println(outputString);
        outputString = String.format("Факториал %d = %d", n, factor(n));
        System.out.println(outputString);
    }
    public static int arithProgr(int n){
        return (n + 1) * n/2;
    }

    public static long factor(int n){
        long factorial = 1;
        for (int i = 2; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

}