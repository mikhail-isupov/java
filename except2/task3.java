public class task3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            //printSum(23, 234);
            int[] abc = {1,2};
            abc[3] = 9;
        } catch (IndexOutOfBoundsException exptn) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException exptn){
            System.out.println("Арифметическая ошибка");
        } catch (Exception exptn){
            System.out.println("Что то пошло не так.");
        }
    }
     
}
