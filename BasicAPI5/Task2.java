package BasicAPI5;
// Вывести список имен в порядке их популярности

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Task2 {
   public static void main(String[] args) {
    
    HashMap<String, Integer> namesMap = new HashMap<>();
    TreeMap<Integer, StringBuilder> rankedNames = new TreeMap<>();
    String inputFileName = "names.txt";

    try {
        
        File inputFile = new File(inputFileName);
        Scanner inputFileScanner = new Scanner(inputFile);
        String name, nextLine;
        int nameCounter;
        while (inputFileScanner.hasNextLine()){
            nextLine = inputFileScanner.nextLine();
            name = nextLine.split(" ")[0];// Считаем что имя идет первое
            if (!name.isEmpty()){
                if (!namesMap.containsKey(name)){
                    namesMap.put(name, 1);
                } else{
                    nameCounter = namesMap.get(name);
                    nameCounter += 1;
                    namesMap.put(name, nameCounter);
                }
            }
        }
        inputFileScanner.close();
    } catch(IOException e) {
        System.out.println("Не могу прочесть файл " + inputFileName);
    }
    
    int nameRank;
    final String SEPARATOR = ",";
    for (String name: namesMap.keySet()){
        nameRank = namesMap.get(name);
        if (rankedNames.containsKey(nameRank)){
            rankedNames.get(nameRank).append(SEPARATOR).append(name);
        } else {
            rankedNames.put(nameRank, new StringBuilder(name));
        }
    }
    for (Integer rank: rankedNames.descendingKeySet()){
        if (rank > 1){
            for (String name: rankedNames.get(rank).toString().split(SEPARATOR)){
                System.out.printf("Имя %s встречается %d раз%s \n", name, rank, declination(rank));
            }
        }
    }
   }    
   public static String declination(int number){
        if (number > 4 && number < 21) {
            return "";
        }
        if (number % 10 > 1 && number % 10 < 5) {
           return "а";
        } else {
            return"";
        }
    }
}
