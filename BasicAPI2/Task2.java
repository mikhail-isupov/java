import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

// Сортирует массив из n элементов, пузырьком, каждая итерация пищется в файл
public class Task2 {
    public static void main(String[] args) {
        int n = 10; // число элементов массива
        int[] array = shuffledArray(n); // создание массива из n элементов заполненного числами 0...n-1 в случайном порядке
        bubbleSort(array); // пузырьковая сортировка массива по возрастанию
    }

    public static int[] shuffledArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i;
        Random rnd = new Random();
        int swap, index;
        for (int i = 0; i < n; i++){
            index = rnd.nextInt(n);
            swap = array[i];
            array[i] = array[index];
            array[index] = swap;
        }
        return array;
    }
    public static void bubbleSort(int[] array){
        try{
        FileWriter fw = new FileWriter("log.txt", true);
        String outputString = Arrays.toString(array);
        fw.append(outputString).append("\n"); // запись состояния массива
        int swap, minIndex;
        for (int i = 0; i < array.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) if (array[j] < array[minIndex]) minIndex = j;
            swap = array[i];
            array[i] = array[minIndex];
            array[minIndex] = swap;
            outputString = Arrays.toString(array);
            fw.append(outputString).append("\n"); // запись состояния массива
        }
        fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }      

}

