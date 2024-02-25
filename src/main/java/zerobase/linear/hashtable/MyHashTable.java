package zerobase.linear.hashtable;

import java.util.*;

public class MyHashTable {
    public static void main(String[] args) {
        Hashtable<String,Integer> hash = new Hashtable<>();
        hash.put("key1",10);
        hash.put("key2",20);
        hash.put("key3",30);

        Hashtable<Integer,Integer> hash2 = new Hashtable<>();

        hash2.put(getHash(1),10);
        hash2.put(getHash(2),20);
        hash2.put(getHash(3),30);
        hash2.put(getHash(4),40);
        hash2.put(getHash(5),50);
    }

    public static int getHash(int key){
        return key%5;
    }
}
