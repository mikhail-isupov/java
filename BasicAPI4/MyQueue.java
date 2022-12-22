package BasicAPI4;

import java.util.LinkedList;
import java.util.List;

public class MyQueue {
    
    private List queue;
    
    public MyQueue(){
        queue = new LinkedList<>();
    }
    public void enqueue(Object obj){
        queue.add(obj);
    }

    public Object dequeue(){
        if (queue.isEmpty()) return null;
        else return queue.remove(0);
    }

    public Object first(){
        if (queue.isEmpty()) return null;
        else return queue.get(0);
    }

}
