package Models;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Exceptions.IllegalDateFormatException;
import Exceptions.IllegalFieldsNumberException;
import Exceptions.IllegalNameException;
import Exceptions.IllegalPhoneFormatException;
import Exceptions.IllegalSexFormatException;
import Exceptions.NonExistentDateException;
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
    
    public PersonalData(String inputString) throws IllegalFieldsNumberException, IllegalDateFormatException, IllegalNameException, IllegalPhoneFormatException, IllegalSexFormatException, NonExistentDateException{
        String surname, familyName, patronymicName, phoneNumber, birthday, sex;
        surname = "";
        familyName = ""; 
        patronymicName = ""; 
        phoneNumber = ""; 
        birthday = ""; 
        sex = "";
        String[] userData = inputString.split(DataStructure.fieldSeparator);
        if (userData.length != fieldsNumber) throw new IllegalFieldsNumberException();
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
        if (familyName.isEmpty()||familyName.isBlank()||surname.isEmpty()||surname.isBlank()||patronymicName.isEmpty()||patronymicName.isBlank()) throw new IllegalNameException();
        if (birthday.isEmpty()) throw new IllegalDateFormatException();
        if (phoneNumber.isEmpty()) throw new IllegalPhoneFormatException();
        if (sex.isEmpty()) throw new IllegalSexFormatException();
        if (!isDateValid(birthday)) throw new NonExistentDateException(birthday);
        this.FAMILYNAME = familyName;
        this.SURNAME = surname;
        this.PATRONYMICNAME =  patronymicName;
        this.PHONENUMBER = phoneNumber;
        this.BIRTHDAY = birthday;
        this.SEX = sex;
    }
}
