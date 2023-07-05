package ru.gb.jcore_final;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для запуска методов работы с игровым полем Крестиков-Ноликов
 */
public class TicTackToeMain {
    public static void main(String[] args) {
        GameField field = new GameField();
        field.setX(0, 0);
        field.setO(1, 1);
        field.setX(2, 2);
        field.setO(2, 0);
        field.setX(0, 2);
        //Заполнили игровое поле
        System.out.println("Игровое поле:");
        System.out.println(field);
        int value = GameField.encode(field);//Закодировали игровое поле в целочисленое значение

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //Создали выходной поток данных
        try (DataOutputStream outData = new DataOutputStream(outputStream)) {
            outData.writeInt(value); // Записали в выходной поток данных полученное значение value
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream file = new FileOutputStream("TickTackToe.data")) {
            file.write(outputStream.toByteArray(), 1, 3); // Записываем в файл только три младших байта
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] in = new byte[4]; // Создали новый массив данных для чтения
        try (FileInputStream file = new FileInputStream("TickTackToe.data")) {
            file.read(in, 1, 3); //Читаем из файла три байта
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(in);//Создали из прочитанного массива байт входной поток данных
        try (DataInputStream inData = new DataInputStream(inputStream)) {
            value = inData.readInt(); // Прочитали из входного потока данных целочисленное значение
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameField newField = GameField.decode(value); //Раскодировали игровое поле из прочитанного из файла значения
        System.out.println("Сохраненное игровое поле:");
        System.out.println(newField); // Распечатали раскодированное игровое поле
    }
}
