public class List {
    private Node head, tail;
    
    List(){
        this.head = null;
        this.tail = null;
    }
    
    public Node getHead(){// Самый первый добавленный элемент списка
        return this.head;
    }

    public Node getTail(){// Самый последний добавленный элемент списка
        return this.tail;
    }

    public void add(Node node){
        if (this.head == null){
            this.head = node;
            this.tail = node;
        } 
        node.setPrevNode(this.tail);
        node.setNextNode(this.head);
        this.head.setPrevNode(node);//Список зациклен
        this.tail.setNextNode(node);
        this.tail = node;     
    }

    public void remove(Node node){// Удаляет элемент node из списка
        Node prev = node.getPrevNode(); // Элемент до node
        if (prev == node) {//если элемент ссылается сам на себя то он один и список нужно обнулить
            this.head = null;
            this.tail = null;
            return;
        }
        Node next = node.getNextNode(); // Элемент после
        next.setPrevNode(prev);
        prev.setNextNode(next);
        if (node == this.head) this.head = next;
        if (node == this.tail) this.tail = prev;
    }

    public Node next(Node node){// Возврашает ссылку на элемент следующий за node
        return node.getNextNode();
    }

    public Node previous(Node node){
        return node.getPrevNode();
    }

    public void reverse(){//Список в обратной последовательности
        Node currentNode = this.head;
        do{
            Node prev = currentNode.getPrevNode();
            Node next = currentNode.getNextNode();
            currentNode.setPrevNode(next);
            currentNode.setNextNode(prev);
            currentNode = next;
        } while (currentNode != this.head);
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }
}
