package Controller;
import java.io.IOException;

import DataManager.DataManager;
import Models.DataStructure;
import Models.PersonalData;
import UserInterface.UserInterface;

public class Controller {
    private static final String exitCommand = "exit";
    public static boolean run(){
        UserInterface.message(DataStructure.info);
        String inputString = UserInterface.getUserData();
        try {
            PersonalData data = new PersonalData(inputString);
            DataManager.save(data);
        } catch (IOException e){
            UserInterface.message(e.getStackTrace().toString());
        }
        catch (Exception e) {
            UserInterface.message(e.getMessage());
        }
        
        return !inputString.equals(exitCommand);

    }
}
