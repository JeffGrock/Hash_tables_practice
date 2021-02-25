
/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Hongbiao Zeng
 * @version Nov 27, 2015
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
       
        count = 0;
        table = new ArrayList<MyHashEntry<K, V>>(tableSize);
        for(int i = 0; i < tableSize; i++) {
            table.add(null);
        }
        
        
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
       this(10);
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return count;
    }
    
    /**
     * clear the table
     */
    public void clear(){
       for (int i = 0; i < table.size(); i++) {
           table.set(i, null);
        }
       count = 0;
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
       int hashValue = key.hashCode()%table.size();
       if(hashValue < 0) {
           hashValue += table.size();
        }
       if (table.get(hashValue) == null) {
           return null;
        }
       MyHashEntry<K, V> hashEntry = table.get(hashValue);
       
       while(hashEntry != null && hashEntry.getKey().compareTo(key) != 0) {
           hashEntry = hashEntry.getNext();
        }
        
       if (hashEntry == null) {
           return null;
        }
        
       return hashEntry.getValue();
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        
        int hashValue = key.hashCode()%table.size();
        if(hashValue < 0) {
           hashValue += table.size();
        }
        if (table.get(hashValue) == null) {
            table.set(hashValue, new MyHashEntry<K, V>(key, value));
            count++;
            return;
        }
        
        MyHashEntry<K, V> hashEntry = table.get(hashValue);
        
        while(hashEntry.getNext() != null && hashEntry.getKey().compareTo(key) != 0) {
            hashEntry = hashEntry.getNext();
        }
        
        if(hashEntry.getKey().compareTo(key) == 0) {
            hashEntry.setValue(value);
        }
        else {
            hashEntry.setNext(new MyHashEntry<K, V>(key, value));
        }
        count++;
    }
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        int hashValue = key.hashCode() % table.size();
        
        if(hashValue < 0) {
            hashValue += table.size();
        }
        
        if (table.get(hashValue) == null) {
            return null;
        }
        
        MyHashEntry<K, V> hashEntry = table.get(hashValue);
        while(hashEntry.getKey().compareTo(key) == 0) {
            V value = hashEntry.getValue();
            table.set(hashValue, hashEntry.getNext());
            count--;
            return value;
        }
        while (hashEntry.getNext() != null && hashEntry.getNext().getKey().compareTo(key) != 0) {
            hashEntry = hashEntry.getNext();
        }
        if (hashEntry.getNext() == null) {
            return null;
        }
        MyHashEntry<K, V> removeEntry = hashEntry.getNext();
        hashEntry.setNext(removeEntry.getNext());
        count--;
        return removeEntry.getValue();
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        return count == 0;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString() {
       
       MyHashEntry<K, V> hashEntry;
       String output = "";
       for (int i = 0; i < table.size(); i++) {
           if (table.get(i) != null) {
               hashEntry = table.get(i);
               output = output + hashEntry.printEntry();
               while (hashEntry.getNext() != null) {
                   hashEntry = hashEntry.getNext();
                   output = output + hashEntry.printEntry();
                }
        }
    }
        return output;
    }
}
