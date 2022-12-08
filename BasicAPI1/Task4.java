import java.util.Scanner;
// Поиск пропущенных цифр в уравнении вида ??? + ??? = value
public class Task4 {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите уравнение c пропущенными цифрами, например ?1?+?1=137");
        String equation = keyboard.nextLine();
        String[] eqParts = equation.split("=");
        String[] numbers = eqParts[0].split("\\+"); 
        int value = Integer.parseInt(eqParts[1]); // Значение выражения
        byte[] firstNumber = strToArray(numbers[0]); // превращаем исходные строки в массив цифр и пропусков
        byte[] secondNumber = strToArray(numbers[1]);
        if (findMissingNumbers(firstNumber, secondNumber, value)){
            String outputString = String.format("%d + %d = %d", arrayToNumber(firstNumber), arrayToNumber(secondNumber), value);
            System.out.println(outputString);
        }
        else System.out.println("Решения нет.");
        keyboard.close();

    }
public static byte[] strToArray(String number) {
    int numberLength = number.length();
    byte[] outputArray = new byte[numberLength];
    for (int i = 0; i < numberLength; i++) outputArray[i] = Character.isDigit(number.charAt(i)) ? Byte.parseByte(Character.toString(number.charAt(i))) : -1;
    return outputArray;// Массив цифр числа, пропущенные заменены на -1
}

public static int arrayToNumber(byte[] number){
    int numberLength = number.length;
    int result = 0;
    for (int i = 0; i < numberLength; i++) result = result * 10 + number[i];
    return result; // Собираем число из массива с цифрами
}

public static boolean findMissingNumbers(byte[] firstNumber, byte[] secondNumber, int value){ // подгонка чисел под value
    int numLength1 = firstNumber.length;
    int numLength2 = secondNumber.length;
    for (int i = 0; i < numLength1; i++) {
        if (firstNumber[i] < 0){
            byte startNumber = i==0 ? (byte)1 : (byte)0; // Первая цифра начинается с 1
            for (byte digit = startNumber; digit <= 9; digit++){
                firstNumber[i] = digit;
                if (findMissingNumbers(firstNumber, secondNumber, value)) return true;
            }
            firstNumber[i] = -1;
        }
    }
    for (int i = 0; i < numLength2; i++) {
        if (secondNumber[i] < 0){
            byte startNumber = i==0 ? (byte)1 : (byte)0; // Первая цифра начинается с 1
            for (byte digit = startNumber; digit <= 9; digit++){
                secondNumber[i] = digit;
                if (findMissingNumbers(firstNumber, secondNumber, value)) return true;
                }
            secondNumber[i] = -1;
        }     
    }
    if (arrayToNumber(firstNumber) + arrayToNumber(secondNumber) == value) return true;
    else return false;
}
}



