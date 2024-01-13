package zerobase.linear;

class Node{
    int data;
    Node next;
    Node(){}
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class MyLinkedList2 extends MyLinkedList{

    MyLinkedList2(Node node){
        this.head = node;
    }

    // 연결리스트에 데이터 추가 , before 데이터 기준으로 뒤 생성(단 없다면 맨앞)
    public void addData(int data, Integer before){
        if(this.head == null){
            this.head = new Node(data, null);
        } else if( before == null){
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while(cur != null){

                if(cur.data == before){

                    if(cur == this.head){
                        this.head = new Node(data, this.head);
                    } else {
                        pre.next = new Node(data, cur);
                    }

                    break;
                }

                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur; // 이전 노드

        while (cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next;
                }else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }

    }
}

public class MyLinkedList {
    Node head; // 가장 앞

    MyLinkedList(){};
    MyLinkedList(Node node){
        this.head = node;
    }
    public boolean isEmpty(){
        if(this.head == null) return true;
        return false;
    }

    public void addData(int data){
        if(this.head == null){
            this.head = new Node(data,null);
        } else {
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    // 맨뒤 데이터 삭제
    public void removeData(){
        if(this.isEmpty()){
            System.out.println("empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while(cur.next != null){
            prev = cur;
            cur = cur.next;
        }

        if( cur == this.head ){
            this.head = null;
        }else{
            prev.next = null;
        }

    }

    public void findData(int data){
        if(this.isEmpty()){
            System.out.println("empty");
            return;
        }

        Node cur = this.head;

        while(cur.next != null){
            if( cur.data == data ){
                System.out.println("find");
                return;
            }
            cur = cur.next;
        }
        System.out.println("not find");
    }


    public void showAllData(){
        if(this.isEmpty()){
            System.out.println("empty");
            return;
        }

        Node cur = this.head;
        while(cur.next != null){
            System.out.println("data : "+cur.data);
            cur = cur.next;
        }
    }

}
