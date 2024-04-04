package zerobase.nonlinear.tree;

import java.util.*;
/**
 * 연결리스트 이용한 이진 트리 구성, 숭회
 */
class Prac2_Node {
    char data;
    Prac2_Node left;
    Prac2_Node right;

    public Prac2_Node(char c, Prac2_Node left,Prac2_Node right) {
        this.data = c;
        this.left = left;
        this.right = right;
    }
}

class Prac2_BinaryTree2{
    Prac2_Node head;
    Prac2_BinaryTree2(){}
    Prac2_BinaryTree2(char[] arr){
        Prac2_Node[] nodes = new Prac2_Node[arr.length];
        for(int i = 0; i<arr.length;i++){
            nodes[i] = new Prac2_Node(arr[i], null, null);
        }

        for(int i=0; i<arr.length;i++){
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < arr.length){
                nodes[i].left = nodes[left];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }

    public void preOrder(Prac2_Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+"");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Prac2_Node node){
        if(node == null){
            return;
        }
        this.preOrder(node.left);
        System.out.print(node.data+"");
        this.preOrder(node.right);
    }

    public void postOrder(Prac2_Node node){
        if(node == null){
            return;
        }
        this.preOrder(node.left);
        this.preOrder(node.right);
        System.out.print(node.data+"");
    }

    public void levelOrder(Prac2_Node node){
        Queue<Prac2_Node> que = new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()){
            Prac2_Node cur = que.poll();

            System.out.print(cur.data+ " " );
            if(cur.left != null){
                que.offer(cur.left);
            }
            if(cur.right != null){
                que.offer(cur.right);
            }

        }

    }


}

public class Practice2 {
}


























