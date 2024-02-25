package zerobase.linear.hashtable;

public class MyHashTable1 {
    Integer[] table;
    int elementCount;

    MyHashTable1(int size){
        this.table = new Integer[size];
        this.elementCount = 0;
    }
    public int getHash(int key){
        return key % this.table.length;
    }
    public void setValue(int key, int data){
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elementCount++;
    }
    public int getValue(int key){
        int idx = this.getHash(key);
        return this.table[idx];
    }
    public void removeValue(int key){
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elementCount--;
    }
}
