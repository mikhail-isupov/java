package Models;
import java.lang.Exception;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//Класс с персональными данными
public class PersonalData {
    public final String SURNAME, FAMILYNAME, PATRONYMICNAME, PHONENUMBER, BIRTHDAY, SEX;
    public final int fieldsNumber = 6;
    private static boolean isDateValid(String dateString)
    {   
        boolean result = false;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(DataStructure.dateFormat);
            if (sdf.format(sdf.parse(dateString)).equals(dateString)) result = true;
        }
        catch (ParseException pe) {}
        return result;
    }
    
    public PersonalData(String inputString) throws Exception{
        String surname, familyName, patronymicName, phoneNumber, birthday, sex;
        surname = "";
        familyName = ""; 
        patronymicName = ""; 
        phoneNumber = ""; 
        birthday = ""; 
        sex = "";
        String[] userData = inputString.split(DataStructure.fieldSeparator);
        if (userData.length > fieldsNumber) throw new Exception("Число введенных полей с данными больше, чем нужно");
        if (userData.length < fieldsNumber) throw new Exception("Число введенных полей с данными меньше, чем нужно");
        for (int index = 0; index < fieldsNumber; index++){
            if (userData[index].matches(DataStructure.phoneNumber)){
                phoneNumber = userData[index];
                continue;
            }
            if (userData[index].matches(DataStructure.birthday)){
                birthday = userData[index];
                continue;
            }
            if (userData[index].matches(DataStructure.sex)){
                sex = userData[index].toLowerCase();
                continue;
            }
            if (familyName.isEmpty()){
                familyName = userData[index];
                continue;
            }
            if (surname.isEmpty()){
                surname = userData[index];
                continue;
            }
            if (patronymicName.isEmpty()){
                patronymicName = userData[index];
                continue;
            }
        }
        if (familyName.isEmpty()) throw new Exception("Не указана фамилия");
        if (surname.isEmpty()) throw new Exception("Не указано имя");
        if (patronymicName.isEmpty()) throw new Exception("Не указано отчество");
        if (birthday.isEmpty()) throw new Exception("Недопустимый формат даты рождения");
        if (phoneNumber.isEmpty()) throw new Exception("Недопустимый формат номера телефона");
        if (sex.isEmpty()) throw new Exception("Недопустимое обозначение пола");
        if (!isDateValid(birthday)) throw new Exception("Некорректная дата " + birthday);
        FAMILYNAME = familyName;
        SURNAME = surname;
        PATRONYMICNAME =  patronymicName;
        PHONENUMBER = phoneNumber;
        BIRTHDAY = birthday;
        SEX = sex;
    }
}
