package BasicAPI6;

import java.io.File;
import java.io.IOException;
// описание свойств ноутбука и методов работы с его свойствами
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Notebook {
    private HashMap<String, Float> notebook;
    // экземпляр класса Notebook содержит соответствующие ID (для связанных таблиц), физические характеристики ноутбука и его цену.
    // поскольку часть характеристик имеет дробное значение, для хранения используется float,
    // а для извлечения методы getInt и getFloat
    public static final String[] KEYS = {"BrandID", "ModelID", "OperatingSystemID", "ScreenSize", "ScreenResolutionX", 
    "ScreenResolutionY", "CPUFrequency", "CoresNumber", "RAMCapacity", "DiskCapacity", "ColorID", "Price" };//Поля записи и порядок их следования
    public static final String[] KEYSDESCRIPTION = {"Название бренда", "Название модели", "Операционная система", "Размер экрана (дюймы)", "Разрешение по горизонтали",
    "Разрешение по вертикали", "Частота процессора (ГГц)", "Число ядер", "Объем оперативной памяти (Гб)", "Объем накопителя (Гб)", "Цвет", "Цена"};
    // ноутбук характеризуется огромным количеством параметров. Тут приведена лишь малая часть. Если заводить под каждый параметр свою переменную и 
    // писать set и get методы для работы с каждой переменной, то работать с таким классом будет невозможно. Поэтому сделана имитация HashMap (доступ по ключу)
    // В этом случае можно легко добавлять новые параметры меняя лишь поля записи (KEYS)
    public static final List<String> IDKEYS = List.of("BrandID", "ModelID", "OperatingSystemID","ColorID");
    // Ключи которые связаны с ID связанных таблиц
    public static final float NUL = 0; // Число для обозначения отсутствия данных
    public static final float ERROR = -1; // Число для обозначения ошибки
    public static final String FIELDSSEPARATOR = ";"; // Разделитель полей записи в строковом представлении
    public static final String KEYSEPARATOR = ":"; // Разделитель пары ключ - значение 

    public static Set<Notebook> loadSet(String fileName){
        Set<Notebook> notebooks = new HashSet<>();
        //загрузка из файла в множество ноутбуков
        try{
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            String textLine;
            while (input.hasNext()){
                textLine = input.nextLine();
                if (!textLine.isEmpty()){
                    Notebook notebook = new Notebook(textLine);
                    //Экземпляр Notebook создается из строкового представления и добавляется в множество
                    notebooks.add(notebook);
                }
            }
        input.close();
        } catch (IOException e){
            System.out.println("Ошибка чтения файла " + fileName);
        }
        return notebooks;
    }
    
    Notebook(){
        this.notebook = new HashMap<>();
        for (String key: KEYS){
            this.notebook.put(key, NUL );
        }
    }
    
    Notebook(String record){// создание экземпляра Notebook из строки
        // вообще хотелось бы создавать экземпляр Notebook из JSON, но стандартных средств для работы с JSON как я понимаю нет.
        // поэтому используется строковое представление ключ:значение;ключ:значение
        this();// Обнуляем поля записи
        String[] fields = record.split(FIELDSSEPARATOR); // Разбили входную строку на поля
        String[] keyValue;
        for (String field: fields){ // пытаемся разбить поле на ключ и значение
            keyValue = field.split(KEYSEPARATOR);
            if (keyValue.length == 2){ // если есть ключ и значение
                try{
                    this.set(keyValue[0], Float.parseFloat(keyValue[1])); // пытаемся преобразовать значение в число и засунуть по ключу
                } catch(NumberFormatException e) { }
            }
        }
    }

    public boolean set(String key, int item){//запись int
        if (this.notebook.containsKey(key) && item >= NUL){// Считаем что параметры Notebook не могут быть отрицательными
            this.notebook.put(key, (float)item);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean set(String key, float item){
        if (this.notebook.containsKey(key) && item >= NUL){// 
            this.notebook.put(key, item); 
            return true;
        }
        else{
            return false;
        }
    }

    public int getInt(String key){
        int result;
        result = (this.notebook.containsKey(key)) ? Math.round(this.notebook.get(key)) : (int)ERROR;
        return result;
    }

    public float getFloat(String key){
        float result;
        result = (this.notebook.containsKey(key)) ? this.notebook.get(key) : ERROR;
        return result;
    }
    
    @Override
    public String toString(){
    //Возвращает строковое представление объекта готовое для записи в файл
        StringBuilder outputString = new StringBuilder();
        float value;
        for (String key: KEYS){
            value = this.notebook.get(key);
            if (value - (int)value == NUL) {// если нет дробной части то это int 
            outputString.append(key).append(KEYSEPARATOR).append((int)value).append(FIELDSSEPARATOR);
            } else{
                outputString.append(key).append(KEYSEPARATOR).append(value).append(FIELDSSEPARATOR);
            }
        }
        return outputString.toString();
    }

    @Override
    public int hashCode(){
        float hash = 0;
        for (String key: KEYS){
            if (!key.equalsIgnoreCase("price")){// стоимость не входит в хэш
                hash += this.notebook.get(key); 
            }
        }
    return Math.round(hash);
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Notebook)){
            return false;
        }
        if (this.hashCode() != object.hashCode()){
            return false;
        }

        for (String key: KEYS){
            if (!key.equalsIgnoreCase("price") && this.notebook.get(key) != ((Notebook)object).getFloat(key)){
                return false;// должны совпадать все поля кроме цены
            }
        }
        return true;
    }

    public boolean isHigher(Notebook notebook){// метод для сравнения двух ноутов
    // передается экземпляр Notebook c минимальными параметрами для фильтрации
    // возвращает true если параметры this выше или равны чем параметры у ноутбука для сравнения
    // BrandID, OperatingSystemID, ColorID проверяются на равенство (одна операционная система не может быть больше другой и цвет тоже)
        
        for (String key : KEYS){
            if (notebook.getFloat(key) > NUL){ // если задан параметр для фильтрации
                if (IDKEYS.contains(key) && notebook.getFloat(key) != this.notebook.get(key)){
                    return false; // если ключ относится к параметрам которые должны быть равны а они не равны
                } else if (!IDKEYS.contains(key) && this.notebook.get(key) != NUL && this.notebook.get(key) < notebook.getFloat(key)){
                    return false; // иначе если параметр относится к тем параметрам которые должны быть больше
                }    
            }    
        }
        return true;
    }
}
