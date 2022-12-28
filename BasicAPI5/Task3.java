package BasicAPI5;

import java.util.Arrays;
import java.util.Random;

// Пирамидальная сортировка
// насколько я понял нужно сначала построить структуру данных - двоичное дерево, 
// где значения в родительских узлах и потомках подчиняются определенной закономерности,
// например число в родительском узле больше чем числа в узлах-потомках
// Тогда на вершине дерева будет максимальное число. Его можно забрать, взять элемент из низа дерева и просеять его
// через дерево. На вершине опять будет новое максимальное число и тд
public class Task3 {
    public static void main(String[] args) {
        int arraySize = 10;
        int[] array = new int[arraySize];
        fillRandom(array);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        buildHeap(array);
        System.out.println("Куча: " + Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--){
            int swap = array[0]; // берем из вершины максимальный элемент
            array[0] = array[i]; // кладем на вершину крайний элемент из кучи;
            array[i] = swap; // кладем максимальный элемент в конец массива
            drownNode(1, i, array); // просеиваем новый элемент через пирамиду
            System.out.println("Процесс сортировки: " + Arrays.toString(array));
        }
        
        
    }
public static void fillRandom(int[] array){// заполняет числами [0...array.length) в случайном порядке

    for (int i = 0; i < array.length; i++){
        array[i] = i;
    }
    Random rnd = new Random();
    int index, swap;
    for (int i = 0; i < array.length; i++){
        index = rnd.nextInt(array.length);
        swap = array[index];
        array[index] = array[i];
        array[i] = swap;
    }
}
public static void buildHeap(int[] array){

    for (int i = array.length / 2; i >= 1; i--){
            drownNode(i, array.length, array); // строим дерево снизу вверх, с крайних родительских узлов, до вершины
            // путем перемещения родительского узла i вниз если он не соответствует критерию кучи
    }
}
public static void drownNode(int parentNode, int heapSize, int[] array){ // номер узла, размер кучи,массив где куча хранится
    int node = parentNode;// родительский узел
    int maxChild, swap;
    maxChild = maxChildIndex(node * 2, heapSize, array); // Индекс наибольшего из потомков узла
    while (maxChild > 0 && array[node - 1] < array[maxChild - 1]){ // пока не вышли за пределы кучи и родитель меньше наибольшего потомка
        swap = array[maxChild - 1];
        array[maxChild - 1] = array[node - 1];
        array[node - 1] = swap; // Меняем родителя и потомка и
        node = maxChild; // перемещаем узел вниз
        maxChild = maxChildIndex(node * 2, heapSize, array); // ищем следующего потомка
    }
}
public static int maxChildIndex(int leftChild, int heapSize, int[] array){//возвращает индекс максимального из потомков либо -1 если вышли за кучу
    int rightChild = leftChild + 1;
    if (leftChild > heapSize){
        return -1; // если потомков нет то возвращаем -1
    } else if (leftChild == heapSize){
        return leftChild; // Если потомок только один то возвращаем его
    } else {
        return (array[leftChild - 1] < array[rightChild - 1]) ? rightChild : leftChild; // иначе выбираем индекс наибольшего из потомков
    }
}    
}
