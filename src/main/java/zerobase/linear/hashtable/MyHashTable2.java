package zerobase.linear.hashtable;

/**
 * 해시 충돌 문제 해결 개방주소법의 선형탐사
 * 
 */
public class MyHashTable2 extends MyHashTable1{
    MyHashTable2(int size) {
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elementCount == this.table.length){
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else{
            int newIdx = idx;
            while(true){
                // 한개씩 공간증가 시키며 찾는다 !
                newIdx = (newIdx+1)%this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elementCount++;
    }

}
