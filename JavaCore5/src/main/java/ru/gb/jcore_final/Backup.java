package ru.gb.jcore_final;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Резервное копирование файлов
 */
public class Backup {
    /**
     * Функция для создания резервной копии фвйлов в папке
     *
     * @param dir - путь к папке в которой нужно выполнять резервное копирование
     */
    public static final String BACKUP_DIR = "/backup";

    public static void backup(String dir) throws IOException {//Функция резервного копирования
        if (dir == null || dir.isEmpty()) dir = "."; // Если ничего не передано, то копируем файлы из текущей директории
        Path workDir = Paths.get(dir);
        Path backupDir = Paths.get(dir + BACKUP_DIR);
        if (!Files.exists(backupDir))
            backupDir = Files.createDirectory(backupDir); // Если директории для резервного копирования нет то ее создаем
        try (Stream<Path> paths = Files.list(workDir)) {//Получение списка файлов из директории
            for (Path path : paths.toList()) {
                if (!Files.isDirectory(path)) {//Если это не вложенная директория
                    Files.copy(path, backupDir.resolve(path.getFileName()), REPLACE_EXISTING);
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            backup(""); // Создается резервная копия текущей директории
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
