//Удалить из списка с целыми числами четные.
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Iterator;

public class Task2 {
    public static void main(String[] args) {
    ArrayList<Integer> myList = randomIntList(10); // создание списка из 10 случайных целых чисел;
    System.out.println(Arrays.toString(myList.toArray()));
    removeEvenNumbers(myList);
    System.out.println(Arrays.toString(myList.toArray()));
    
    }
    
    public static ArrayList<Integer> randomIntList(int n){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i=0; i<n; i++) myList.add(rnd.nextInt(n));
        return myList;
    }

    public static void removeEvenNumbers(ArrayList<Integer> myList){
        //for (int i = 0; i < myList.size(); i++) if (myList.get(i) % 2 == 0) myList.remove(i);
        Iterator<Integer> item = myList.iterator();
        while (item.hasNext()) if (item.next() % 2 == 0) item.remove();   
    }
    
}
