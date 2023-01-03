package BasicAPI6;

import java.util.Map;
import java.util.Set;

// интерфейс пользователя
public class NotebookUI {
    public static void showMenu(){
        System.out.println("Введите число из списка для выбора критерия.");
        System.out.println("Для выхода из программы введите отрицательное число. Для окончания ввода критериев любое другое положительное.");
        for (int i = 0; i < Notebook.KEYS.length; i++){
            System.out.printf("%d: %s \n", i, Notebook.KEYSDESCRIPTION[i]);
        }
    }

    public static void showLinkedTable(Map<Integer, String> table){
        for (Integer key: table.keySet()){
            System.out.printf("%d %s \n", key, table.get(key));
        }
        System.out.println("Выберите ID из связанной таблицы: ");
    }

    public static void printSet(Set<Notebook> notebooks, LinkedTables tables){
        String key;
        StringBuilder outputString = new StringBuilder();
        for (Notebook notebook: notebooks){
            outputString.setLength(0);
            for (int i = 0; i < Notebook.KEYS.length; i++){
                key = Notebook.KEYS[i];

                if (notebook.getFloat(key) > Notebook.NUL && Notebook.IDKEYS.contains(key)){// если нужно брать значение по ключу из связанной таблицы и поле не пустое
                    outputString.append(Notebook.KEYSDESCRIPTION[i]).append(Notebook.KEYSEPARATOR).append(tables.get(key).get(notebook.getInt(key))).append(Notebook.FIELDSSEPARATOR).append(" ");
                // по ключу извлекается связанная таблица, по значению ключа из таблицы извлекается значение поля 
                } else if (notebook.getFloat(key) > Notebook.NUL) {//пустые поля не печатаем
                    float valueFloat = notebook.getFloat(key);
                    int valueInt = (int)valueFloat;
                    if (valueInt-valueFloat==0){
                        outputString.append(Notebook.KEYSDESCRIPTION[i]).append(Notebook.KEYSEPARATOR).append(valueInt).append(Notebook.FIELDSSEPARATOR).append(" ");
                    } else{
                        outputString.append(Notebook.KEYSDESCRIPTION[i]).append(Notebook.KEYSEPARATOR).append(valueFloat).append(Notebook.FIELDSSEPARATOR).append(" ");
                    }
                }
            }
            System.out.println(outputString.toString());
            System.out.println();
        }
    } 

}

