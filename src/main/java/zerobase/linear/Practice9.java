package zerobase.linear;

/**
 * 연경 뒤집기 문제
 * 주어긴 연결리스트에서 시작위치부터 끝 위치 사이의 노드들을 뒤집으시오
 */
public class Practice9 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.addData(6);
        linkedList.addData(7);
        linkedList.showAllData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showAllData();

    }

    public static MyLinkedList reverseList(MyLinkedList linkedList, int left, int right){
        Node cur1 = null;
        Node pre1 = null;

        cur1 = linkedList.head;
        for(int i =0; i<left-1;i++){
            pre1 = cur1;
            cur1 = cur1.next;
        }

        Node cur2 = cur1;
        Node pre2 = pre1;
        Node after = null;
        // 스왑이 필요한 곳 즉 after 가 계속 마지막 노드의 next를 가르
        for(int i = left; i <= right; i++){
            after = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = after;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return linkedList;
    }


}
