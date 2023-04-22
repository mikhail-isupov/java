import java.util.Scanner;

public class task1{
    public static float getFloat(){
        System.out.println("Введите дробное число.");
        Scanner kbrd = new Scanner(System.in);
        float number = 0;
        boolean isParseFloat = false; 
        do{
            try{
                number = Float.parseFloat(kbrd.nextLine());
                isParseFloat = true;
            } catch(NumberFormatException exptn){
                System.out.println("Это не число. Повторите ввод.");
            }
        } while(!isParseFloat);
        kbrd.close();
        return number;
    }

    public static void main(String[] args) {
        System.out.println(getFloat());
    }
}