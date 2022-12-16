// Найти минимальное максимальное и среднее из целочисленного списка
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
    ArrayList<Integer> myList = randomIntList(10); // создание списка из 10 случайных целых чисел;
    System.out.println(Arrays.toString(myList.toArray()));
    minMaxMean(myList);
    }
    
    public static ArrayList<Integer> randomIntList(int n){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i=0; i<n; i++) myList.add(rnd.nextInt(n));
        return myList;
    }

    public static void minMaxMean(ArrayList<Integer> myList){
        int min = myList.get(0);
        int max = min;
        int sum = 0;

        for (int item: myList){
            if (item > max) max = item;
            if (item < min) min = item;
            sum+= item;
        }
        double mean = (double)sum/myList.size();

        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее значение: " + mean);
    }
}
