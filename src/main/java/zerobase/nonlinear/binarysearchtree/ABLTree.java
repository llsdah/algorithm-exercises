package zerobase.nonlinear.binarysearchtree;

// 비선형 자료구조 - 이진탐색트리2 AVL 트리 - 삽입

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class ABLTree {
    class Node {
        int key;
        int height;
        Node left;
        Node right;
        Node(int key, Node left, Node right){
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }

    Node head;

    public int height(Node node){
        if(node ==null){
            return -1;
        }
        return node.height;
    }

    //오른쪽으로 이동한다.
    public Node rightRotate(Node node){
        Node lNode = node.left;
        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(height(node.left),height(node.right))+1;
        lNode.height = Math.max(height(lNode.left),height(lNode.right))+1;

        return lNode;
    }
    // 왼쪽으로 이동한다.
    public Node leftRotate(Node node){
        Node rNode = node.right;

        node.right = rNode.left;
        rNode.left = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        rNode.height = Math.max(height(rNode.left),height(rNode.right))+1;

        return rNode;
    }
    public Node lrRotat(Node node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public Node rlRotat(Node node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(Node node){
        if (node == null){
            return 0;
        }
        return height(node.left)-height(node.right);
    }

    public void insert(int key){
        this.head = insert(this.head, key);
    }

    public Node insert(Node node, int key){

        if(node == null){
            return new Node(key, null,null);
        }
        if(key < node.key){
            node.left = insert(node.left,key);
        }else{
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.left),height(node.right))+1;

        int balance = getBalance(node);

        //LL
        if(balance>1 && key < node.left.key){
            return rightRotate(node);
        }

        //RR
        if(balance<-1 && key > node.right.key){
            return leftRotate(node);
        }

        //LR
        if(balance>1 && key > node.left.key){
            return lrRotat(node);
        }

        //RL
        if(balance<-1 && key < node.right.key){
            return rlRotat(node);
        }


        return node;
    }

    public void delete(int key){
        this.head = delete(this.head, key);
    }

    public Node delete(Node node, int key){
        if(node == null){
            return null;
        }
        System.out.println("node : "+node.key+"   key :"+key);

        if(key < node.key){
            node.left = delete(node.left,key);
        }else if(key > node.key){
            node.right = delete(node.right, key);
        }else{ //삭제 부분

            if(node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }else{
                System.out.println();
                Node predecessor = node;
                Node successor = node.left;
                System.out.println("successor.key : "+successor.key);
                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                    System.out.println("successor.key : "+successor.key);
                }

                predecessor.right = successor.left;
                node.key = successor.key;

                System.out.println();
            }
        }

        node.height = Math.max(height(node.left),height(node.right))+1;

        int balance = getBalance(node);

        //LL
        if (balance>1 && getBalance(node.left)>0){
            return rightRotate(node);
        }
        //RR
        if (balance<-1 && getBalance(node.right)<0){
            return leftRotate(node);
        }
        //LR
        if (balance>1 && getBalance(node.left)<0){
            return lrRotat(node);
        }
        //RL
        if (balance<-1 && getBalance(node.right)>0){
            return rlRotat(node);
        }

        return node;
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while( !queue.isEmpty() ){
            Node cur = queue.poll();

            System.out.print(cur.key+" ");
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
        ABLTree avl = new ABLTree();

        //LL
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);
        avl.levelOrder(avl.head);

        //RR
        avl.insert(40);
        avl.insert(50);
        avl.levelOrder(avl.head);

        //LR
        avl.insert(5);
        avl.insert(7);
        avl.levelOrder(avl.head);

        //RL
        avl.insert(60);
        avl.insert(55);
        avl.levelOrder(avl.head);

        //delete
        avl.delete(55);
        avl.levelOrder(avl.head);

        avl.delete(60);
        avl.levelOrder(avl.head);



    }
}
