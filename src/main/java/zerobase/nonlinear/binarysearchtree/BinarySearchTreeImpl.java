package zerobase.nonlinear.binarysearchtree;

import java.util.*;

public class BinarySearchTreeImpl {
    class Node {
        int key;
        Node left;
        Node right;
        Node(int key, Node left, Node right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    Node head;

    BinarySearchTreeImpl(int key){
        this.head = new Node(key, null, null);
    }

    public void addNode(int key){
        if(this.head == null){ // 해드 널 체크
            System.out.println("head is null");
            this.head = new Node(key,null,null);
            return;
        }
        // 노드가 있다면, 순회 해야됩니다.
        Node cur = this.head;

        while(true){
            Node pre = cur;// 현재것을 쫒아갈 pre

            if(key < cur.key){ // 비교대상 노드의 키보다 작으면, 왼쪽
                cur = cur.left;
                if(cur == null){
                    pre.left = new Node(key, null, null);
                    break;
                }
            }else { // 비교대상 노드의 키보다 크면, 왼쪽
                cur = cur.right;

                if(cur == null){
                    pre.right = new Node(key,null,null);
                    break;
                }
            }
        }
    }

    // 삭제를 해보장!
    public void removeNode(int key){
        Node parent = null; // 부모노드
        Node successor = null; // 위치를 변경해줘야하는 노드
        Node predecessor = null; // succesor의 부모노드
        Node child = null; // successor의 자식이 있는지 확인용도

        Node cur = this.head;// 어떤 노드를 지울 것인지 확인
        while(cur != null){
           if(key == cur.key){
               break;
           }

           parent = cur;// 부모노드 저장
           if(key < cur.key){
               cur = cur.left;
           }else{
               cur = cur.right;
           }
        }

        if(cur == null){
            System.out.println("키에 해당하는 노드가 없습니다.");
            return;
        }

        if(cur.left == null && cur.right == null){ //leaf 노드
            if(parent == null){
                this.head = null;
            }else{
                if(parent.left==cur){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }

        } else if ( (cur.left != null && cur.right == null) ||
                (cur.left == null && cur.right != null) ){ // 자식 노드가 하나인경우

            if( cur.left != null ){ // 자식노드 넣기
                child = cur.left;
            }else {
                child = cur.right;
            }

            if(parent == null){ // 루트 노드라는 것
                this.head = child;
            }else {

                if (parent.left == cur) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }

            }

        }else{ // ** 자식노드가 둘인경우
            // 좌측 서브트리에서 가장큰것을 찾느다.
            predecessor = cur;
            successor = cur.left;

            while(successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }

            predecessor.right = successor.left;
            successor.left = cur.left;
            successor.right = cur.right;

            if(parent == null){
                this.head = successor;
            }else{
                if(parent.left == cur){
                    parent.left = successor;
                }else {
                    parent.right = successor;
                }
            }

        }

    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);


        // 삭제
        System.out.println("삭제");
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);

    }

}
















