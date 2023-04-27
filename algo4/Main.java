

public class Main {
    public static void main(String[] args) {
        RBtree tree = new RBtree();
        //Добавляем значения в дерево и печатаем его
        for (int i = 0; i < 10; i++) {
           tree.add(i);
        } 
        System.out.println(tree.toString());
    }
}
