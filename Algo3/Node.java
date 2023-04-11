public class Node{
    private int value;
    private Node prevNode, nextNode;
    
    Node(){
        this.prevNode = null;
        this.nextNode = null;
        this.value = 0;
    }
    
    Node(int value){
        this();
        this.value = value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setPrevNode(Node node){
        this.prevNode = node;
    }

    public void setNextNode(Node node){
        this.nextNode = node;
    }

    public Node getPrevNode(){
        return this.prevNode;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

}