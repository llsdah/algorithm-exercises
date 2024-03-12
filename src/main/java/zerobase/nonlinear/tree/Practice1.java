package zerobase.nonlinear.tree;

public class Practice1 {

    public static void main(String[] args) {
        char ch='A';
        char[] arr = new char[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=(char)('A'+i);
        }
        Prac1_BinaryTree prac1BinaryTree
                = new Prac1_BinaryTree(arr);
    }
}


class Prac1_BinaryTree{
    char[] arr;

    Prac1_BinaryTree(char[] data){
        this.arr = data.clone();
    }
    public void preOrder(int idx){
        System.out.print(this.arr[idx] + " ");
        int left = 2*idx+1;
        int right = 2*idx+2;
        if(left<this.arr.length){
            this.preOrder(left);
        }
        if(right<this.arr.length){
            this.preOrder(right);
        }
    }
    public void inOrder(int idx){

        int left = 2*idx+1;
        int right = 2*idx+2;
        if(left<this.arr.length){
            this.preOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if(right<this.arr.length){
            this.preOrder(right);
        }
    }
    public void postOrder(int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left<this.arr.length){
            this.preOrder(left);
        }

        if(right<this.arr.length){
            this.preOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx){

        for(int i=0;i<this.arr.length;i++){
            System.out.print(this.arr[idx] + " ");
        }
    }

}