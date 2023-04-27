import java.util.ArrayList;
import java.util.List;

public class RBtree{
//Реализуем структуру и методы балансировки красно-черного дерева

    private Node root;
    RBtree(){
        this.root = null; 
    }

    public boolean add(int value){
        boolean result = true;
        if (this.root != null ) {
            result = this.add(value, this.root);
            if (result) this.root = rebalance(this.root);
        }
        else this.root = new Node(value);
        this.root.color = false; //Корень всегда черный
        return result;
    }

    private boolean add(int value, Node node){// Рекурсивный обход дерева и попытка добавить новую ноду в один из null-листьев
        if (value == node.value) return false;// Дублирующий элемент
        if (value > node.value && node.rightChild != null) {
            boolean result = this.add(value, node.rightChild);//Если значение больше и есть правый ребенок то проверяем его
            if (result) node.rightChild = rebalance(node.rightChild);// Добавили что то к узлу и его нужно балансировать
            return result;
        }
        if (value < node.value && node.leftChild != null) {
            boolean result = this.add(value, node.leftChild);//Если значение меньше и есть левый ребенок то проверяем его
            if (result) node.leftChild = rebalance(node.leftChild);
            return result;
        }
        
        if (value > node.value) node.rightChild = new Node(value);//Если значение больше и правого ребенка нет то создаем его
        else node.leftChild = new Node(value);//Если значение меньше и левого ребенка нет то создаем его
        return true;
    }

    private static Node rebalance(Node node){
        boolean isBalanced, leftChildColor, rightChildColor, leftGrandchildColor;
        do{
            isBalanced = true;
            leftChildColor = node.leftChild != null && node.leftChild.color; // Null листы черные
            rightChildColor = node.rightChild != null && node.rightChild.color;
            leftGrandchildColor = node.leftChild != null && node.leftChild.leftChild != null && node.leftChild.leftChild.color;
            if (rightChildColor && !leftChildColor){
                //Если правая нода красная и левая нода черная - левосторонний поворот
                node = leftTurn(node);
                isBalanced = false;
                continue;
            }
            if (leftChildColor && leftGrandchildColor){
                // Если левая нода красная и левая нода левой ноды красная - правосторонний поворот
                node = rightTurn(node);
                isBalanced = false;
                continue;
            }
            if (leftChildColor && rightChildColor) {
                //Если левая нода красная и правосторонняя нода красная делаем свап цвета.
                node.leftChild.color = false;// Дети становятся черными
                node.rightChild.color = false;
                node.color = true; // Нода становится красной
                isBalanced = false;
                continue;
            }
        } while (!isBalanced);
        return node;
    }
    private static Node leftTurn(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = true;
        return rightChild;
    }

    private static Node rightTurn(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = true;
        return leftChild;
    }
    @Override
    public String toString(){//Строковое представление дерева
        StringBuilder strng = new StringBuilder();
        List<Node> parentNodes = new ArrayList<>();
        parentNodes.add(this.root);
        do{
            List<Node> childrenNodes = new ArrayList <>();
            for (Node node : parentNodes){
                if (node != null) {
                    childrenNodes.add(node.leftChild);
                    childrenNodes.add(node.rightChild);
                    strng.append(node.value).append(" ");
                } else {
                    strng.append("N ");
                }
            }
            strng.append("\n");
            parentNodes = childrenNodes;
        } while(!parentNodes.isEmpty());
        return strng.toString();
    }

    private class Node{
        public int value;
        public boolean color;
        public Node leftChild;
        public Node rightChild;
        Node(int value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
            this.color = true; // Новая нода всегда красная
        }
    }
}