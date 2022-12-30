package BasicAPI5;
import java.util.ArrayList;

public class PhoneRecord {
// Класс описывающий единичную запись в телефонной книге и методы работы с ней
    private String name;
    private String surname;
    private String organization;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> emails;
    public final int FIELDSNUMBER = 5; // сколько полей в записи
    public final String EMPTYFIELD = "-";
    
    PhoneRecord(){ // Создание пустой телефонной записи
        name = EMPTYFIELD;
        surname = EMPTYFIELD;
        organization = EMPTYFIELD;
        phoneNumbers = new ArrayList<>();
        phoneNumbers.add(EMPTYFIELD);
        emails = new ArrayList<>();
        emails.add(EMPTYFIELD);
    }
    PhoneRecord(String record){// Создание телефонной записи из строки вида "name;surname;organization;phone1,phone2,phone3;email1,email2"
        this();
        String[] recordFields = record.split(";");
        if (recordFields.length == FIELDSNUMBER){ // Проверка на соответствие набора данных в строке структуре записи
            name = recordFields[0];
            surname = recordFields[1];
            organization = recordFields[2];
            for (String phone: recordFields[3].split(",")) {
                this.addPhone(phone);
            }
            for (String email: recordFields[4].split(",")){
                this.addEmail(email);
            }
        }   
    }
    String getName(){
        return name;
    }
    String getSurname(){
        return surname;
    }
    String getOrganization(){
        return organization;
    }
    String[] getPhones(){// Можно забрать телефоны как массив
        return phoneNumbers.toArray(new String[0]);
    }
    String[] getEmails(){// Можно забрать емейлы как массив
        return emails.toArray(new String[0]);
    }
    void setName(String personName){
        if (personName.isEmpty()||personName.isBlank()) {
            name = EMPTYFIELD;
        }
        else {
            name = personName;
        }
    }
    void setSurname(String personSurname){
        if (personSurname.isEmpty()||personSurname.isBlank()){
            surname = EMPTYFIELD;
        } else{
            surname = personSurname;
        }
        
    }
    void setOrganization(String personOrganization){
        if (personOrganization.isEmpty()||personOrganization.isBlank()){
            organization = EMPTYFIELD;
        } else{
            organization = personOrganization;
        }
        
    }
    void addPhone(String personPhone){
        if (personPhone.isEmpty()||personPhone.isBlank()||personPhone.equals(EMPTYFIELD)) return; // Пустое поле не добавляем, оно уже есть
        if (phoneNumbers.get(0).equals(EMPTYFIELD)){
            phoneNumbers.remove(0); // Пустое поле нужно заместить
        }
        phoneNumbers.add(personPhone);
    }
    void addEmail(String personEmail){
        if (personEmail.isEmpty()||personEmail.isBlank()||personEmail.equals(EMPTYFIELD)) return; // Пустое поле не добавляем
        if (emails.get(0).equals(EMPTYFIELD)){
            emails.remove(0); // Пустое поле нужно заместить
        }
        emails.add(personEmail);
    }
    String toStr(){// Возвращает строковое представление записи вида "name;surname;organization;phone1,phone2,phone3;email1,email2"
        StringBuilder outputString = new StringBuilder();
        outputString.append(name).append(";").append(surname).append(";").append(organization).append(";");
        
        if (!phoneNumbers.isEmpty()){//Если есть телефоны
            for (String phone: phoneNumbers){
                outputString.append(phone).append(",");
            }
            outputString.deleteCharAt(outputString.length() - 1); // Последняя запятая лишняя
        }
        outputString.append(";"); // не забыть про разделитель полей
        
        if (!emails.isEmpty()){
            for (String email: emails){
                outputString.append(email).append(",");
            }
            outputString.deleteCharAt(outputString.length() - 1);
        }
    return outputString.toString();
    }
    //boolean removeRecord(String record){//метод для удаления записи по значению для удаления ненужных записей из phoneNumbers и emails
    //для упрощения не реализован но вообще нужен    
    //}
}
