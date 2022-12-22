package BasicAPI4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Перевод арифметического выражения в обратную польскую запись и ее вычисление
public class Task4 {
    
    public static int counter; //счетчик доступный из всех рекурсивных вызовов.
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение, например (1+1)/(1+1)");
        String equation = keyboard.nextLine();
        keyboard.close();
        counter = 0; // Перед вызовом метода перевода в обратную польскую нотацию обнуляем счетчик используемый в методе
        String equationRPN = toReversePolishNotation(equationPreprocessing(equation)).toString();
        System.out.println(equationRPN);
        System.out.println(solveRPNequation(equationRPN.split(" ")));
    }
    
    public static double solveRPNequation(String[] equation){
        final String OPERATORS = "+-*/";
        Stack<Double> stack = new Stack<>();
        double x; double y;
        for (String item: equation){
            if (OPERATORS.contains(item)){
                y = stack.pop();
                x = stack.pop();
                if (item.equals("+")) stack.push(x + y);
                if (item.equals("-")) stack.push(x - y);
                if (item.equals("*")) stack.push(x * y);
                if (item.equals("/")) stack.push(x / y);
            } else stack.push(Double.parseDouble(item));
        }
        return stack.pop();
    }
    public static StringBuilder toReversePolishNotation(String[] equation){
        final String OPERATORS = "+-*/";
        final String HIGHOPERATORS = "*/";
        final char SPACE = ' ';
        List<StringBuilder> numbers = new LinkedList<>(); // тут будут храниться числа либо вычисленные рекурсивно выражения в скобках
        List<String> operators = new LinkedList<>(); // тут будут храниться арифметические операторы

        while (counter < equation.length && ! equation[counter].equals(")")){ // бежим до конца выражения либо закрывающей скобки
            if (equation[counter].equals("(")) { // если скобка то вычисляем выражение в скобке и добавляем в numbers
                counter +=1; // Иначе при вызове рекурсии будет опять скобка
                numbers.add(toReversePolishNotation(equation));
            } else if (OPERATORS.contains(equation[counter])) operators.add(equation[counter]);
            else numbers.add(new StringBuilder(equation[counter])); // если не скобка и не оператор то число
            counter+=1;
        }
// Идем по списку чисел и операций, сначала смотрим приоритетные потом другие. Вычисляем по правилам RPN выражение, записываем его в numbers, удаляем использованные выражения и операторы.
        int index = 0;
        while (index < operators.size()){ 
            if (HIGHOPERATORS.contains(operators.get(index))) {
                numbers.get(index).append(SPACE).append(numbers.remove(index+1)).append(SPACE).append(operators.remove(index));
            } else index+=1;
            }
        index = 0;
//Второй проход для низкоприоритетных операций, все тоже самое.       
        while (index < operators.size()){ 
            numbers.get(index).append(SPACE).append(numbers.remove(index+1)).append(SPACE).append(operators.remove(index));  
            }    
        return numbers.get(0);// В итоге в numbers остается записанная по правилам RPN запись.
    }
    
    public static String[] equationPreprocessing(String equation){ //Обрабатывает входное арифметическое выражение и разбивает его на числа и операторы
        final Character SPACE = ' ';
        final ArrayList<Character> OPERATORS = new ArrayList<>(Arrays.asList('(', ')', '+', '-', '*', '/' ));
        char lastAddedChar = (char)0;
        StringBuilder filteredEquation = new StringBuilder();// убираем все введенные пользователем пробелы
        for (int i = 0; i < equation.length(); i++) if (equation.charAt(i)!= SPACE) filteredEquation.append(equation.charAt(i));
    
        StringBuilder processedEquation = new StringBuilder(); // и расставляем пробелы правильно
        for (int i = 0; i < filteredEquation.length(); i++) {
            if (OPERATORS.contains(filteredEquation.charAt(i))) { // операторы выделяются пробелом
                if (i > 0 && lastAddedChar != SPACE) processedEquation.append(SPACE);
                processedEquation.append(filteredEquation.charAt(i));
                processedEquation.append(SPACE);
                lastAddedChar = SPACE;
            } else {
                processedEquation.append(filteredEquation.charAt(i)); // все остальное копируется как есть
                lastAddedChar = filteredEquation.charAt(i);
            }
        } // Такой подход конечно не различает унарный минус и оператор вычитания.
    
        String newEquation = processedEquation.toString();
        return newEquation.split(" ");
    }
}
