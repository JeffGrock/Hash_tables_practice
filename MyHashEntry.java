
/**
 * class MyHashEntry. A Hash Entry as a single linked list Node
 * 
 * @author Hongbiao Zeng
 * @version Dec 11, 2015
 */
public class MyHashEntry<K extends Comparable<K> , V>
{
    private K key;
    private V value;
    MyHashEntry<K, V> next;
    
    /**
     * Constructor 
     * @param key The key of MyHashEntry
     * @param value The value of myHashEntry
     */
    public MyHashEntry(K key, V value){
        this.key = key;
        this.value = value;
        next = null;
       
    }
    
    /**
     * get the key
     * @return the key of the ordered pair
     */
    public K getKey(){
       return key;
    }
    
    /**
     * set the key for this ordered pair
     * @param key The key for this ordered pair
     */
    public void setKey(K key){
        this.key = key;
    }
    
    /**
     * get the value of this ordered pair
     * @return the value of this ordered pair
     */
    public V getValue(){
       return value;
    }
    
    /**
     * set the value of this ordered pair
     * @param value the new value of this ordered pair
     */
    public void setValue(V value){
        this.value = value;
    }
    
    /**
     * set next entry for this entry
     * @param next A reference to the next entry
     */
    public void setNext(MyHashEntry<K, V> next){
       this.next = next;
    }
    
    /**
     * get next entry
     * @return a reference to the next entry
     */
    public MyHashEntry<K, V> getNext(){
       return next;
    }
    
    public String printEntry() {
        return " {Key: " + key + " " + "Value: " + value + "} ";
    }
}
