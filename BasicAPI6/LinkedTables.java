package BasicAPI6;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// класс для работы с таблицами связанными с экземплярами Notebook
public class LinkedTables {
    private HashMap<String, Map<Integer, String>> tables; // связь между ключами Notebook и связанными таблицами

    LinkedTables(){
        tables = new HashMap<>();
    }

    public boolean set(String key, Map<Integer, String> object){
        if (Notebook.IDKEYS.contains(key)){// если вводимый ключ соответствует связанной таблице
            this.tables.put(key, object);
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, String> get(String key){
        if (this.tables.containsKey(key)){
            return this.tables.get(key);
        } else {
            return null;
        }
    }

    public static Map<Integer, String> loadTable(String fileName){
        //загрузка данных из связанной таблицы
        Map<Integer, String> table = new TreeMap<>();
        try{
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            String textLine;
            String[] record;
            while (input.hasNext()){
                textLine = input.nextLine();
                record = textLine.split(Notebook.KEYSEPARATOR);
                    if (record.length == 2){
                        try{
                            table.put(Integer.parseInt(record[0]),record[1]);
                            // первая колонка это id, вторая - описание поля
                        } catch(NumberFormatException e){
                            System.out.println("Неверный формат ID в файле " + fileName);
                        }
                    }
                }
            input.close();
        } catch(IOException e){
                System.out.println("Ошибка чтения файла " + fileName);
            }
        return table;
    }
}
