package zerobase.linear;

// 추가 자료 구조 없이 연결 리스트 만으로 풀어보기
// 앞으로 뒤로 읽어도 같은것
public class Palindrome {
    public static void main(String[] args) {

    }

    public static boolean checkPalindrome(MyLinkedList list){
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while(cur != null){
            cnt ++;
            right = cur;
            cur = cur.next;
        }
        Node preRight = right;
        for(int i=0;i<cnt/2;i++){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = left;
            while(right.next != preRight){
                right = right.next;
            }
        }
        return true;
    }
}
