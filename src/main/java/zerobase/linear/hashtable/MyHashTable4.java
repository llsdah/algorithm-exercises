package zerobase.linear.hashtable;

/**
 * 해시 충돌 개방주소법 - 이중해싱
 */
public class MyHashTable4 extends MyHashTable1{
    int c;
    MyHashTable4(int size) {
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if (this.elementCount == this.table.length){
            System.out.println("table full!");
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else {
            // 두번쨰 해시 함수 사용
            int newIdx = idx;
            int cnt = 1;
            while(true){
                newIdx = (newIdx + this.getHash2(newIdx)*cnt)%this.table.length;
                if(this.table[newIdx]==null){
                    break;
                }
                cnt ++;
            }
            this.table[newIdx] = data;
        }
    }
    public int getHash2(int key){
        int hash = 1+key % this.c;
        return hash;
    }
    public int getHashC(int size){
        int c = 0;

        if(size<=2){
            return size;
        }
        for(int i = size-1;i>2;i--){
            boolean isPrime = true;
            for (int j = 2; j<i;j++){
                // 떨어지면 소수가 아님
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                c = i;
                break;
            }
        }
        return c;
    }
    
}
