package zerobase.linear;


public class MyCycleLinkedList {
    Node1 head;
    Node1 tail;

    public MyCycleLinkedList(Node1 cur) {
        this.head = cur;
        this.tail = cur;
        cur.next = this.head;
        cur.prev = this.head;
    }
    public boolean isEmpty(){
        if(this.head ==null){
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData){
        if(this.head == null){
            Node1 node1 = new Node1(data, null, null);
            this.head = node1;
            this.tail = node1;
            node1.next = node1;
            node1.prev = node1;
        }else if(beforeData == null){
            Node1 node1Before = new Node1(data, this.head,this.tail);
            this.tail.next = node1Before;
            this.head.prev = node1Before;
            this.tail = node1Before;
        }else {
            Node1 cur = this.head;
            Node1 pre = cur;
            do{
                if(cur.data == beforeData){
                    if(cur == this.head){
                        Node1 newNode1 = new Node1(data, this.head, this.tail);
                        this.tail.next = newNode1;
                        this.head.prev = newNode1;
                        this.head = newNode1;
                    }else {
                        Node1 newNode1 = new Node1(data, cur,pre);
                        pre.next = newNode1;
                        cur.prev = newNode1;
                    }
                }
            }while(cur != this.head);
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("null");
            return;
        }

        Node1 cur = this.head;
        Node1 pre = cur;
        while(cur != null){
            if(cur.data == data){
                if (cur == this.head && cur == this.tail ){
                    this.head = null;
                    this.tail = null;
                }else if(cur == this.head){
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                }else if(cur == this.tail){
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;

                }else{
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
        if (this.isEmpty()){
            System.out.println("비엇따");
            return;
        }

        Node1 node = this.head;
        // 원형이라는 것을 생각
        while(node.next != this.head){
            System.out.print(node.data + " ");
            node = node.next;
        }
        // 가장 끝 노드
        System.out.println(node.data + " ");
    }
}
