public class Main {
    public static void main(String[] args) {
        
        List newList = new List(); //Создаем новый список
        
        for (int i = 0; i < 10; i++){
            newList.add(new Node(i)); // Заполняем его новыми значениями от 1 до 9
        }
        newList.remove(newList.getHead());//Пробуем удалить самое первое и самое последнее значение
        newList.remove(newList.getTail());
        
        Node node = newList.getHead(); //Получаем ссылку на новое начало списка

        do {
            System.out.println(node.getValue());
            node = newList.next(node); // Получаем след элемент, обходим весь список и выводим все элементы 1..8
        } while (node != newList.getHead()); 

        newList.reverse(); // Пробуем развернуть список

        node = newList.getHead(); //Получаем ссылку на новое начало списка

        do {
            System.out.println(node.getValue());
            node = newList.next(node); // Получаем след элемент, обходим весь список и выводим все элементы 8..1
        } while (node != newList.getHead()); 

        

    }
}
