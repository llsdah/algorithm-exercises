package zerobase.linear.queue;

import java.util.ArrayList;

/**
 * 리스트로 큐 구현
 */
public class MyQueue1 {
    ArrayList list;

    MyQueue1(){
    this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(this.list.size()==0){
            return true;
        }
        return false;
    }

    public void push(int data){
        this.list.add(data);
    }
    public Integer pop(){
        if(this.list.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(0);
        this.list.remove(0);
        return data;
    }
    public Integer peek(){
        if(this.list.isEmpty()){
            return null;
        }
        int data = (int) this.list.get(0);
        return data;
    }


}
