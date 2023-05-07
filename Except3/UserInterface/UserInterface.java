package UserInterface;
import java.util.Scanner;

public class UserInterface {
    private static Scanner kbrd = new Scanner(System.in);
    public static String getUserData(){
        return kbrd.nextLine();
    }
    public static void message(String strng){
        System.out.println(strng);
    }
}
