package BasicAPI4;
// переворот списка LinkedList

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task1 {
    public static void main(String[] args) {
        String inputString = "a b c d";
        List<String> strList = new LinkedList<>(Arrays.asList(inputString.split(" "))); // создаем LinkedList из массива строк
        print(strList);     
        System.out.println(); 
        print(reverse(strList));
        System.out.println(); 
        
        List<Integer> intList = new LinkedList<>();
        for (int i=1; i <= 9; i++) intList.add(i);
        print(intList);      
        System.out.println(); 
        print(reverse(intList));
    }

    public static void print(List list){
        for (Object item: list) System.out.print(item + " ");
    }

    public static List reverse(List list){
       List newList = new LinkedList();
       ListIterator iterator = list.listIterator();
       while (iterator.hasNext()) iterator.next(); // идем в конец списка
       while (iterator.hasPrevious()) newList.add(iterator.previous()); // идем в начало списка и копируем в новый список
       return newList;
    }    
}
