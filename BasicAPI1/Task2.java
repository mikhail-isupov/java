//Поиск простых чисел
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Верхняя граница диапазона для поиска простых чисел?");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        keyboard.close();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(3);
        int number, upper_limit, index;
        for (int i = 2; i <= (n - 1) / 2;  i++){
            number = 2 * i + 1;
            upper_limit = (int)Math.round(Math.sqrt(number));
            index = 0;
            while (number % primes.get(index) != 0 && primes.get(index) <= upper_limit) index++;            
            if (number % primes.get(index) !=0 ) primes.add(number);
        }
        System.out.print(2);
        for (Integer prime : primes) System.out.print(" " + prime);
    }
}
