package BasicAPI4;

import java.util.Scanner;

public class Task2 {
    
    public static void main(String[] args) {
        String inputString = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Проверка самодельной очереди.");
        System.out.println("Введите любую строку для добавления в очередь, или команды: ");
        System.out.println("remove: извлечь и удалить элемент из начала очереди, first: извлечь элемент из начала, quit: завершение работы.");
        MyQueue queue = new MyQueue();

        while(!inputString.equals("quit")){
            inputString = keyboard.nextLine();
            if (inputString.equals("remove")) System.out.println(queue.dequeue());
            else if (inputString.equals("first")) System.out.println(queue.first());
            else queue.enqueue(inputString);
        }
        keyboard.close();
    }
    
}
