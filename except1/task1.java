import java.util.Random;

public class task1{
    
    private static String[] stringArray = {null, "NAN"};
    
    public static void doNothing(String[] array){
        Random rnd = new Random();
        int index = rnd.nextInt(array.length + 1);
        System.out.println(array[index].length());
        System.out.println(Integer.parseInt(array[index]));
        
    }
    
    public static void main(String[] args) {
        doNothing(stringArray);
    }
}