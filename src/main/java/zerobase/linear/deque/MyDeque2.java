package zerobase.linear.deque;

public class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque2(int size){
        this.arr = new int[size+1];
    }

    // 배열 사이즈 조정
    public void increaseSize(){
        int[] temp = this.arr.clone();
        this.arr = new int[this.arr.length*2];
        int start = (this.front+1) % temp.length;
        int end = (this.rear+1) % temp.length;

        int idx = 1; // 왜냐면 f 가 0번 인덱스이기 위해서
        for(int i=start;i != end; i = (i+1)%temp.length){
            this.arr[idx++] = temp[i];
        }
        this.front = 0;
        this.rear = idx -1;
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }

    // 조정후 데이터 입력
    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }
        this.arr[this.front] = data;
        this.front = (this.front-1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }
        this.rear = (this.rear+1) % this.arr.length;
        this.arr[this.rear]=data;
    }
    //**
    public void addMiddle(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }
        //원소 갯수
        int element = this.rear - this.front;
        if(element<0){
            element = this.arr.length+element;
        }
        // 중간 지점 찾기
        int mid = (this.rear - element/2 + this.arr.length) % this.arr.length+1;
        // 1 2 3 4 5 0 0 0
        // 1 2 3 m 4 5 0 0
        // 1 2 3 4 5 s
        // 데이터를 한개씩 밀기
        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - element/2 + this.arr.length)%this.arr.length;
        for(int i = start; i !=end; i = (i-1+this.arr.length)%this.arr.length){
            this.arr[i] = this.arr[(i-1+this.arr.length) % this.arr.length];
        }

        // 데이터 입력후 변경
        this.arr[mid] = data;
        this.rear = (this.rear+1)%this.arr.length;

    }


    // front에서 제외
    // 현재 front 공간에서는 값이 없다 뒤로 감아야됩니다.
    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque os empty");
            return null;
        }
        this.front = (this.front+1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println();
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear -1 + this.arr.length)%this.arr.length;
        return data;
    }

    public void printDeque(){
        int start = (this.front+1)%this.arr.length;
        int end = (this.rear+1)%this.arr.length;

        for(int i = start; i != end; i = (i+1)%this.arr.length){
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}
