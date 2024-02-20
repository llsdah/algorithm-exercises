package zerobase.linear.deque;

import java.util.ArrayList;

public class MyDeque1 {
    ArrayList list;
    MyDeque1(){
        this.list = new ArrayList();
    }
    public boolean isEmpty(){
        if (this.list.size() == 0){
            return true;
        }
        return false;
    }
    public void addFirst(int data){
        this.list.add(0,data);
    }
    public void addLast(int data){
        this.list.add(data);
    }
    public Integer removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(0);
        this.list.remove(0);
        return data;
    }
    public Integer removeLast(){
        if(this.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(this.list.size()-1);
        this.list.remove(this.list.size()-1);
        return data;
    }


}
