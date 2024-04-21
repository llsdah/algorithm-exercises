package zerobase.nonlinear.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImplRecursive {
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

    BinarySearchTreeImplRecursive(int key){
        this.head = new Node(key,null,null);
    }

    public Node addNodeRecurvice(Node cur, int key){
        if( cur == null ){
            return new Node(key,null,null);
        }

        if(key <cur.key){
            cur.left = addNodeRecurvice(cur.left,key);
        }else{
            cur.right = addNodeRecurvice(cur.right,key);
        }

        return cur;
    }

    public Node removeNodeRecurvice(Node cur, int key){
        if(cur == null){
            return null;
        }

        if(key < cur.key){
            cur.left = removeNodeRecurvice(cur.left,key);
        } else if (key > cur.key) {
            cur.right = removeNodeRecurvice(cur.right,key);
        }else { // 삭제할 케이스를 찾는 경우 입니다.

            if(cur.left == null){
                return cur.right;
            } else if (cur.right == null) {
                return cur.left;
            }else{ // 자식 노드 가 두개
                Node prodcessor = cur;
                Node successor = cur.left;

                while(successor.right != null){
                    prodcessor = successor;
                    successor = successor.right;
                }

                prodcessor.right = successor.left;
                cur.key = successor.key;

            }
        }

        return cur;
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }

            if(cur.right != null){
                queue.offer(cur.right);
            }
        }


    }


}









