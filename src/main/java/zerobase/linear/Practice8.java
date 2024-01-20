package zerobase.linear;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Practice8 {
    /**
     * 단방향 연결 리스트 에서 중복데이터 찾아 삭제 하기
     * 1 3 3 1 4 2 4 2
     * 1 3 4 2
     */

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addData(1);
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(4);
        linkedList.addData(2);

    }

    public static LinkedList removeDup(MyLinkedList before){
        MyLinkedList after = new MyLinkedList();

        Node cur = before.head;
        while(cur != null){
            if(!after.findData(cur.data)){
                after.addData(cur.data);
            }
            cur = cur.next;
        }


        return null;
    }

    public static boolean findData(){

    }
}
