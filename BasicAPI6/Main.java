package BasicAPI6;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> colors;// таблица цветов
        Map<Integer, String> brands; // таблица брендов
        Map<Integer, String> models; // таблица моделей ноутбуков
        Map<Integer, String> os; // таблица операционных систем
        Set<Notebook> notebooks; // множество ноутбуков
        
        colors = LinkedTables.loadTable("colors.csv");
        brands = LinkedTables.loadTable("brands.csv");
        models = LinkedTables.loadTable("models.csv");
        os     = LinkedTables.loadTable("os.csv");
        notebooks = Notebook.loadSet("notebooks.csv");
        // загрузка данных из связанных таблиц
        LinkedTables tables = new LinkedTables();
        tables.set("BrandID", brands);
        tables.set("ModelID", models);
        tables.set("OperatingSystemID", os);
        tables.set("ColorID", colors);
        // Связали ключи Notebook cо связанными таблицами
        
        int choise = 0;
        float param;
        String key;
        Scanner keyboard = new Scanner(System.in);
        while (choise >= 0){
            Notebook notebook = new Notebook();
            NotebookUI.showMenu();
            choise = keyboard.nextInt();
            while (choise >= 0 && choise < Notebook.KEYS.length){
                key = Notebook.KEYS[choise];
                if (Notebook.IDKEYS.contains(key)){//если выбрали ключ, относящийся к связанным таблицам
                    NotebookUI.showLinkedTable(tables.get(key));//вывести связанную таблицу по ключу
                    choise = keyboard.nextInt();
                    while (!tables.get(key).containsKey(choise)){
                        choise = keyboard.nextInt();// пока не будет введен правильный ключ
                    }
                    notebook.set(key, choise);// записываем ID из связанной таблицы
                } else {
                    System.out.println("Введите минимальное значение для параметра " + Notebook.KEYSDESCRIPTION[choise]);
                    param = keyboard.nextFloat();
                    if (!notebook.set(key, param)){
                        System.out.println("Неправильное значение, не записано.");
                    }
                }
            System.out.println("Добавьте следующий критерий для фильтрации или закончите ввод.");
            choise = keyboard.nextInt();
            }
            if (choise >= 0){
                Set<Notebook> filteredNotebooks = new HashSet<>();
                for (Notebook item: notebooks){
                    if (item.isHigher(notebook)){
                        filteredNotebooks.add(item);
                    }
                }
                NotebookUI.printSet(filteredNotebooks, tables);
            }
        }
        keyboard.close();
    }
}
