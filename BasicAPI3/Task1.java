// Сортировка методом слияния
package BasicAPI3;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = initArray(9); // Массив из 9 элементов заполненный числами от 1 до 9 в случайном порядке
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static int[] initArray(int n){
        int[] array = new int[n];
        int swap, index;
        Random rnd = new Random();

        for (int i=0; i < n; i++) array[i] = i + 1;// Заполнили массив числами от 1 до n
        for (int i = 0; i < n; i++){
            index = rnd.nextInt(n);
            swap = array[i];
            array[i] = array[index];
            array[index] = swap; // переставление элементов с индексом i и случайным индексом index
        }
        return array;
    }
    public static void mergeSort(int[] array){
        if (array.length < 2) return; // Единичный и пустой массив не сортируем
        int[] arrayA = Arrays.copyOfRange(array, 0, array.length/2);
        int[] arrayB = Arrays.copyOfRange(array, array.length/2, array.length); // Делим пополам и сортируем
        mergeSort(arrayA);
        mergeSort(arrayB); 
        int indexA = arrayA.length - 1; // Конец массива A
        int indexB = arrayB.length - 1;
        int index = array.length - 1; // Конец выходного массива
        while (indexA >= 0 || indexB >=0 ){ // Проходим по массивам A и B с конца пока не упремся в начало
            if (indexA >=0 && indexB >=0) { // если оба массива еще полны то сравниваем их элементы
                if (arrayA[indexA] > arrayB[indexB]){
                    array[index] = arrayA[indexA]; // копируем наибольший элемент и сдвигаемся к предыдущему
                    indexA-=1;
                } else {
                    array[index] = arrayB[indexB]; // копируем наибольший элемент и сдвигаемся к предыдущему
                    indexB-=1;
                }
            } else { // если один массив пуст то копируем поэлементно второй;
                if (indexA >= 0){
                    array[index] = arrayA[indexA]; 
                    indexA-=1;
                }
                if (indexB >= 0){
                    array[index] = arrayB[indexB]; 
                    indexB-=1;
                }
            }
        index-=1;
        }
    }
}
