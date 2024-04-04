package zerobase.nonlinear.tree;

import java.util.*;
/**
 * 트리 구조 복습
 */

class Prac3_node{
    int data;
    Prac3_node left;
    Prac3_node right;
    Prac3_node parent;

    public Prac3_node(int data, Prac3_node left, Prac3_node right, Prac3_node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Prac3_node head;

    public BinaryTree3(char[] arr) {
        Prac3_node[] nodes = new Prac3_node[arr.length];
        for(int i=0; i<arr.length;i++){
            nodes[i] = new Prac3_node(arr[i],null,null,null);
        }

        for(int i=0; i<arr.length;i++){
            int left = 2*i+1;
            int right = 2*i+2;

            if(left<arr.length){
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if(right<arr.length){
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Prac3_node searchNode(char data){
        Queue<Prac3_node> queue = new LinkedList<>();
        queue.add(this.head);
        while(!queue.isEmpty()){
            Prac3_node cur = queue.poll();
            if(cur.data == data){
                return cur;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }

        }
        return null;
    }

    public Integer checkSize(char data){
        Prac3_node node = this.searchNode(data);
        Queue<Prac3_node> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while(!queue.isEmpty()){
            Prac3_node cur = queue.poll();

            if(cur.left != null){
                queue.offer(cur.left);
                size++;
            }

            if(cur.right != null){
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }


}

public class Practice3 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for(int i=0;i<10;i++){
            arr[i] = (char)('A'+i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        Prac3_node b = bt.searchNode('B');
        System.out.println( "root :"+ b.data);

        if(b.left != null ){
            System.out.println( "left :"+ b.left.data);

        }
        if(b.right != null ){
            System.out.println( "right :"+ b.right.data);
        }

        Prac3_node f = bt.searchNode('F');
        System.out.println( "parent :"+ f.parent.data);

        System.out.println( "Leaf " );
        for(int i=0;i<arr.length;i++){
            Prac3_node cur = bt.searchNode((char)('A'+i));
            if(cur.left==null && cur.parent==null){
                System.out.print(cur.data+" ");
            }

        }
        System.out.println();

        //depth
        Prac3_node E = bt.searchNode('E');
        Prac3_node cur = E;
        int cnt = 0;
        while(cur.parent!=null){
            cur = cur.parent;
            cnt++;
        }
        System.out.println();

        //
        System.out.println("Level2 node : ");
        for(int i=0;i<arr.length;i++){
            Prac3_node target = bt.searchNode((char)('A'+i));
            cur = target;
            cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt ++;
            }
            if(cnt == 2){
                System.out.print(target.data + " ");
            }

        }

        //Height
        int maxCnt = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            Prac3_node target = bt.searchNode((char)('A'+i));
            cur = target;
            cnt = 0;
            while (cur.parent != null){
                cur = cur.parent;
                cnt++;
            }
            if (maxCnt < cnt) {
                maxCnt=cnt;
            }
        }
        System.out.print("Height : "+maxCnt);

        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B size : "+size);


    }
}


















