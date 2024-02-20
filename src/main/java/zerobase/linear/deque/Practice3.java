package zerobase.linear.deque;

/**
 * 데크 변형
 * 중간에 데이터를 추가하는 유형입니다.
 * MyDeque2 에 있는 내용으로 대체 합니다.
 */
public class Practice3 {
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
}
