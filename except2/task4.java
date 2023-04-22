import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        try{
            System.out.println(getString());
        } catch (Exception expt){
            System.out.println(expt.getMessage());
        }
    }

    public static String getString() throws Exception{
        String outputString = "";
        Scanner kbrd = new Scanner(System.in);
        outputString = kbrd.nextLine();
        kbrd.close();
        if (outputString.isEmpty()){
            throw new Exception("Пустые строки вводить нельзя!");
        }
        return outputString;
    }
}
