package BasicAPI5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Task1 {
    //Реализуйте структуру телефонной книги с помощью HashMap
    public static void main(String[] args) {
        String fileName = "phonebase.csv"; // Для упрощения задается фиксированным
        TreeMap<Integer, PhoneRecord> phoneBook = new TreeMap<>(); // Создаем пустую телефонную книгу
        int id;
        try{
            File file = new File(fileName);
            Scanner inputScanner = new Scanner(file);
            String[] inputData;
           
            while (inputScanner.hasNextLine()){
                inputData = inputScanner.nextLine().split(":"); // читается строка и делается попытка разбить на id и данные
                if (inputData.length == 2){// если разбили на 2 части то считаем что все ок
                    id = Integer.parseInt(inputData[0]); // надо конечно проверить на исключения но не будем
                    PhoneRecord record = new PhoneRecord(inputData[1]);
                    phoneBook.put(id, record);
                }
            }
            inputScanner.close();
        } catch(IOException e){
            System.out.println("Не могу прочесть файл " + fileName);
        }
        String command = "";
        Scanner keyboard = new Scanner(System.in);
        while (!command.equals("quit")){
            printPhoneBook(phoneBook);
            System.out.println("Введите команду: addrecord - добавить запись,\n" +
            "delrecord - удалить запись, addphone - добавить в запись телефон,\n" +
            "addemail - добавить в запись email, save - сохранить, quit - выход");
            command = keyboard.next();
            
            if (command.equals("addrecord")||command.equals("delrecord")
            ||command.equals("addphone")||command.equals("addemail")){
                System.out.println("Введите id записи: ");
                id = keyboard.nextInt();
            } else {
                id = 0;
            }
            
            if (command.equals("addrecord")){
                System.out.println(addRecord(keyboard, id, phoneBook));
            } else if (command.equals("delrecord")){
                System.out.println(delRecord(id, phoneBook));
            } else if (command.equals("addphone")) {
                System.out.println(addPhone(keyboard, id, phoneBook));
            } else if (command.equals("addemail")){
                System.out.println(addEmail(keyboard, id, phoneBook));
            } else if (command.equals("save")){
                System.out.println(save(phoneBook, fileName));
            } else if (command.equals("quit")){
                System.out.println(command);
            } else {
                System.out.println("команда неизвестна.");
            }
        }
        keyboard.close();
    }
    public static void printPhoneBook(TreeMap<Integer, PhoneRecord> phoneBook){
        String[] phones, emails;
        String phone, email, name, surname, organization;
        for (Integer id: phoneBook.keySet()){
            phones = phoneBook.get(id).getPhones();
            emails = phoneBook.get(id).getEmails();
            name = phoneBook.get(id).getName();
            surname = phoneBook.get(id).getSurname();
            organization = phoneBook.get(id).getOrganization();
            int rows = (phones.length > emails.length) ? phones.length : emails.length;
            for (int i = 1; i <= rows; i++){
                name = (i == 1) ? name : "";
                surname = (i == 1) ? surname : "";
                organization = (i == 1) ? organization : "";
                phone = (i > phones.length) ? "" : phones[i - 1];
                email = (i > emails.length) ? "" : emails[i - 1];
                System.out.printf("%3d %10s %15s %20s %20s %15s \n", id, name, surname, organization, phone, email);
            }
                    
        }
    }
    public static String addRecord(Scanner keyboard, int id, TreeMap<Integer, PhoneRecord> book){
        if (book.containsKey(id)){
            return "Такая запись уже есть, удалите ее сначала.";
        }
        PhoneRecord record = new PhoneRecord();
    
        System.out.println("Введите имя");
        record.setName(keyboard.next());
        System.out.println("Введите фамилию");
        record.setSurname(keyboard.next());
        System.out.println("Введите организацию");
        record.setOrganization(keyboard.next());
        System.out.println("Введите телефон");
        record.addPhone(keyboard.next());
        System.out.println("Введите емейл");
        record.addEmail(keyboard.next());
        book.put(id, record);
        return "Запись " + id + " добавлена";
    }

    public static String delRecord(int id, TreeMap<Integer, PhoneRecord> book){
        if (!book.containsKey(id)){
            return "Такой записи нет";
        }
        book.remove(id);
        return "Запись " + id + " удалена";
    }

    public static String addPhone(Scanner keyboard, int id, TreeMap<Integer, PhoneRecord> book){
        if (!book.containsKey(id)){
            return "Такой записи нет";
        }
        System.out.println("Введите телефон");
        book.get(id).addPhone(keyboard.next());
        return "Телефон добавлен в запись " + id;
    }

    public static String addEmail(Scanner keyboard, int id, TreeMap<Integer, PhoneRecord> book){

        if (!book.containsKey(id)){
            return "Такой записи нет";
        }
        System.out.println("Введите емейл");
        book.get(id).addEmail(keyboard.next());
        return "Емейл добавлен в запись " + id;
    }
    public static String save(TreeMap<Integer, PhoneRecord> book, String fileName){
        File outputFile = new File(fileName);
        try{
            FileWriter file = new FileWriter(outputFile);
            StringBuilder outputString = new StringBuilder();
            for (Integer id: book.keySet()){
                outputString.append(id).append(":").append(book.get(id).toStr()).append("\n");
                file.write(outputString.toString());
                outputString.setLength(0);
            }
            file.close();
        } catch(IOException e) {
            return "Ошибка записи в файл" + fileName;
        } 
            return "Запись осуществлена успешно";
    }
    
}
