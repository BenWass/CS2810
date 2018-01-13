package serverNetwork;

import java.util.LinkedList;

public class ResponceStack {

    private LinkedList<Responce> list;
    private int size;
    
    public ResponceStack() {
        list = new LinkedList<>();
        size = 0;
    }
    
    public void addResponce(Responce tmp) {
        list.add(tmp);
        size++;
    }
    
    public Responce pop() {
        size--;
        return list.removeFirst();
    }
    
    public int getSize() {
        return size;
    }
    
    public Boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
