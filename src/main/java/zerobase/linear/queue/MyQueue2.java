package zerobase.linear.queue;

/**
 * 배열로 큐 구현
 * 공간 할당으로 인해 복잡 -> 원형 큐 형태로 관리를 해야됩니다.
 */
public class MyQueue2 {
    int[] arr;
    int front = 0; //
    int real = 0 ;

    MyQueue2(int size){// 원형 큐를 위해 1개 더 추가
        this.arr = new int[size+1];
    }

    public boolean isEmpty(){
        if((this.real == this.front)){
            System.out.println(" empty ");
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if((this.real+1) % this.arr.length == this.front){
            System.out.println("꽉참");
            return true;
        }
        return false;
    }
    public void addQue(int data){
        if(this.isFull()){
            return;
        }
        this.real = (this.real + 1) % this.arr.length;
        this.arr[this.real] = data;
    }
    public Integer delQue(){
        if(this.isEmpty()){
            return null;
        }
        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void print(){
        int start = (this.front+1)% this.arr.length;
        int end = (this.real +1 )% this.arr.length;
        for(int i = start; i !=end; i = (i+1)%this.arr.length){
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2(5);
        myQueue2.addQue(1);
        myQueue2.addQue(2);
        myQueue2.addQue(3);
        myQueue2.addQue(4);
        myQueue2.addQue(5);
        myQueue2.addQue(6); // 에러 반환

        myQueue2.print();

        System.out.println(myQueue2.delQue());
        myQueue2.print();
        System.out.println(myQueue2.delQue());
        myQueue2.print();

        myQueue2.addQue(6);
        myQueue2.addQue(7);

        myQueue2.print();

        System.out.println(myQueue2.delQue());
        System.out.println(myQueue2.delQue());
        System.out.println(myQueue2.delQue());
        System.out.println(myQueue2.delQue());
        System.out.println(myQueue2.delQue());
        System.out.println(myQueue2.delQue());
        myQueue2.print();


    }
}
