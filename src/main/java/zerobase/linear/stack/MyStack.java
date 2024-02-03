package zerobase.linear.stack;

import java.util.*;

/**
 * 리스트활용한 stack 구현
 */
public class MyStack {
    ArrayList list;

    MyStack(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if (this.list.size() == 0){
            return true;
        }
        return false;
    }

    public void push(int data){
        this.list.add(data);
    }

    public Integer pop() {

        if(this.list.isEmpty()){
            return null;
        }

        int data = (int) this.list.get(this.list.size()-1);
        this.list.remove(this.list.size()-1);
        return data;
    }

    public Integer peek(){
        if(this.list.isEmpty()){
            System.out.println();
            return null;
        }
        int data = (int) this.list.get(this.list.size()-1);
        return data;
    }
    public void print(){
        System.out.println(this.list);
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
    }

}
