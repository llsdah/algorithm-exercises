package zerobase.linear;

import java.util.LinkedList;

class Node1 {
    int data;
    Node1 next;
    Node1 prev;

    public Node1(int data, Node1 next, Node1 prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class MyLinearList2 extends LinkedList {
    Node1 head;
    Node1 tail;

    public boolean isEmpty(){
        if(this.head==null){
            return true;
        }
        return false;
    }
    // 연결리스트에 데이터 추가 , before 데이터 기준으로 뒤 생성(단 없다면 맨앞)
    // 즉, (100,1) 이면 100,1  순서입니다.
    // befor 라고 했지만 전이 아닌 후 느낌..?
    public void addData(int data, Integer beforData){
        if(this.head == null){
            this.head = new Node1(data,null,null);
            this.tail = this.head;
        }else if(beforData == null){// 맨앞 해드에 추가합니다.
            this.tail.next = new Node1(data, null, this.tail);
            this.tail = this.tail.next;
        } else {
            Node1 cur = this.head;
            Node1 pre = cur;
            while(cur != null) {
                if (cur.data == beforData) {
                    if (cur == this.head) {
                        this.head = new Node1(data, this.head, null);
                        this.head.next.prev = this.head;
                    } else {
                        pre.next = new Node1(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }


    public void removeData (int data){
        if(this.isEmpty()){
            System.out.println("비었다");
        }
        Node1 cur = this.head;
        Node1 pre = cur;

        while( cur != null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){
                    this.head = null;
                    this.tail = null;
                }else if (cur == this.head){
                    this.head = cur.next;
                    this.head.prev = null;
                }else if( cur == this.tail){
                    this.tail = this.tail.next;
                    this.tail.next = null;
                }else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void showData(){
        if(this.isEmpty()){
            System.out.println("null");
        }
        Node1 cur = this.tail;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }

}














