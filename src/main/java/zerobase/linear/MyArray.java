package zerobase.linear;

public class MyArray {

    int[] arr;

    static {
        int art =1;
    }
    MyArray(int size){
        this.arr = new int[size];
    }

    public void insertData(int index, int data){
        if(index<0||index>this.arr.length){
            System.out.println("index error");
            return;
        }

        int[] arrCopy = this.arr.clone();
        this.arr = new int[this.arr.length+1];

        for(int i =0; i<index;i++){
            this.arr[i] = arrCopy[i];
        }
        this.arr[index] = data;

        for(int i = index+1;i<this.arr.length+1;i++){
            this.arr[i] = arrCopy[i-1];
        }
    }

    public void removeData(int data){
        int target = -1;
        for(int i =0;i<this.arr.length;i++){
            if(this.arr[i]==data){
                target=i;
                break;
            }
        }

        if(target==-1){
            System.out.println("data is not exist");
        }else{
            int[] arrCopy = this.arr.clone();
            this.arr = new int[this.arr.length+1];

            //System.arraycopy(arrCopy, 0, this.arr, 0, target);
            for(int i =0; i<target;i++){
                this.arr[i] = arrCopy[i];
            }

            for(int i = target;i<this.arr.length;i++){
                this.arr[i] = arrCopy[i+1];
            }
        }

    }
}


