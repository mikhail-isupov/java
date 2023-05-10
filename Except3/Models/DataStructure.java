package Models;
//Класс с описанием форматов данных
public class DataStructure {
    public static final String info = "Введите через пробел персональные данные: Фамилия Имя Отчество Телефон (число без разделителей) Дата Рождения (дд.мм.гггг) Пол (m/f)";
    public static final String fieldSeparator = "\\s+";
    public static final String phoneNumber = "\\d+";
    public static final String sex = "[mfMF]{1}";
    public static final String birthday = "\\d{2}\\.\\d{2}\\.\\d{4}";
    public static final String dateFormat = "dd.MM.yyyy";
}
