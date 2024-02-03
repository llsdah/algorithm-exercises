package zerobase.linear.stack;

/**
 * 배열로 만든 스택
 */
public class MyStackArray {

    int[] arr;
    int top = -1;
    MyStackArray(int size){
        arr = new int[size];
    }

    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.top == this.arr.length-1){
            return true;
        }
        return false;
    }

    public void push(int data){
        if(this.isFull()){
            return;
        }
        this.top+=1;
        this.arr[this.top] = data;
    }
    public Integer pop(){
        if(this.isEmpty()){
            return null;
        }
        int data = this.arr[this.top];
        this.top = -1;
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            return null;
        }
        int data = this.arr[this.top];
        return data;
    }



}
