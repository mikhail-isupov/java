package DataManager;

import java.io.FileWriter;
import java.io.IOException;

import Models.PersonalData;

public class DataManager {
    public static void save(PersonalData data) throws Exception{
        try(FileWriter file = new FileWriter(data.FAMILYNAME, true)){
            String outputString = String.format("<%s><%s><%s><%s><%s><%s>\n", data.FAMILYNAME, data.SURNAME, data.PATRONYMICNAME, data.BIRTHDAY, data.PHONENUMBER, data.SEX);
            file.write(outputString);
        } catch(IOException e){
            throw new Exception(e.getStackTrace().toString());
        }
    }
}
