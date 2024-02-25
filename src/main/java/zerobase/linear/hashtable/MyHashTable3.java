package zerobase.linear.hashtable;

/**
 * 해시 충돌의 개발주소법 - 제곱 탐사
 */
public class MyHashTable3 extends MyHashTable1{

    MyHashTable3(int size) {
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elementCount == this.table.length){
            System.out.println("Hash table is full");
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else {
            int newIdx = idx;
            int cnt = 0;
            while(true){
                newIdx = (newIdx + (int)Math.pow(2,cnt)) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elementCount++;
    }
}
