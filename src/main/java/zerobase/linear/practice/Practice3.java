package zerobase.linear.practice;

/**
 * 풍선 터트리기!
 * 1번 풍선 터트린다 -> 번호가 나온다 (-3) 해당 값만큼 이동해서 위치의 풍선 터트린다
 * 3 2 1 -3 -1 => 터트려지는 순서 1 4 5 3 2
 * 3 2 -1 -2 => 1 4 2 3
 */
public class Practice3 {
    public static void main(String[] args) {

    }
    public static void sol(int[] data){
        LinkedList3 linkedList3 = new LinkedList3();
        // 데이터 입력
        for(int i = 0; i<data.length;i++){
            linkedList3.add(i,data[i]);
        }

        Node3 cur = linkedList3.head;

        int visitCnt = 0;
        int cmd = 0;

        while(visitCnt != data.length){
            int cnt = 0;
            // 해당 위치로 이동
            while(cnt != Math.abs(cmd)){
                if(cmd > 0){
                    cur = cur.next;
                }else{
                    cur = cur.prew;
                }
                if(cur.visit == false){
                    cnt++;
                }
            }
            // 터트림
            cur.visit = true;
            visitCnt++;
            cmd = cur.cmd;

        }


    }
}



class Node3 {
    int data; // 풍선번호
    int cmd; // 이동할 값

    boolean visit; // 터졌는지
    Node3 next; // 다음
    Node3 prew; // 후

    public Node3(int data, int cmd, boolean visit, Node3 next, Node3 prew) {
        this.data = data;
        this.cmd = cmd;
        this.visit = visit;
        this.next = next;
        this.prew = prew;
    }
}

class LinkedList3 {
    Node3 head;

    // 원형으로 만들기 위한 작업.
    public void add(int data, int cmd){
        if(this.head == null){
            this.head = new Node3(data, cmd , false, null, null);
            this.head.next = this.head;
            this.head.prew = this.head;
        }else {
            Node3 cur = this.head;
            while(cur.next != this.head){
                cur = cur.next;
            }
            cur.next = new Node3(data, cmd, false, cur.next, cur);
            this.head.prew = cur.next;
        }
    }

}
