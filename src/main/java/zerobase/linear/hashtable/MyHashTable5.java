package zerobase.linear.hashtable;

/**
 * 해시 충돌 분리연결법
 */
class Node{
    int key;
    int data;
    Node next;
    Node(){}
    Node(int key, int data, Node next){
        this.key = key;
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node head;

    LinkedList(){}
    LinkedList(Node node){
        this.head = node;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void addData(int key, int data){
        if(this.head == null){
            this.head = new Node(key, data, null);
        }else{
            Node cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(key,data,null);
        }
    }

    public void removeData(int data){
        if( this.isEmpty()){
            return;
        }
        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur.key == data){
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

    public Integer findData(int data){
        if(this.isEmpty()){
            return null;
        }

        Node cur = this.head;
        while(cur != null){
            if(cur.key == data){
                System.out.println("data");
                return cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return null;
    }
}

public class MyHashTable5 {
    LinkedList[] table;

    MyHashTable5(int size){
        this.table = new LinkedList[size];
        for(int i=0;i<size;i++){
            this.table[i] = new LinkedList(null);
        }
    }

    public int getHash(int key){
        return key % this.table.length;
    }
    public void setValue(int key, int data){
        int idx = this.getHash(key);
        this.table[idx].addData(key,data);

    }
    public int getValue(int key){
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }
    public void removeValue(int key){
        int idx = this.getHash(key);
        this.table[idx].removeData(key);

    }
    
}













