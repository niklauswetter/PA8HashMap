import java.util.*;

public class MyHashMap<K,V>
{
    //Fields
    private HashTable<K, V> hashTable = new HashTable<>();

    /**
     * default constructor
     */
    public MyHashMap()
    {

    }

    /**
     * debug method for testing
     */
    public void debug()
    {
        System.out.println(this.hashTable);
    }

    /**
     * removes all elements from the hashmap
     */
    public void clear()
    {
        for(int i = 0;i<this.hashTable.hashTable.size();i++)
            this.hashTable.hashTable.get(i).clear();
    }

    /**
     * Returns true if the key argument has a mapping
     * @param key the key to search for in the hashmap
     * @return boolean
     */
    public boolean containsKey(K key)
    {
        return this.hashTable.contains(key);
    }

    /**
     * Returns true if the map maps one or more keys to the val argument
     * @param val value to search for key mappings for
     * @return boolean
     */
    public boolean containsValue(V val)
    {
        return false;
    }

    /**
     * Returns the value mapped to the key argument
     * @param key key for the value you want to retrieve
     * @return V for mapped keys, null for unmapped keys
     */
    public V get(K key)
    {
        return null;
    }

    /**
     * Returns true if the hashmap has 0 elements in it
     * @return boolean
     */
    public boolean isEmpty()
    {
        boolean flag = true;
        for(LinkedList linkedList:this.hashTable.hashTable)
            if(!linkedList.isEmpty()){flag=false;}
        return flag;
    }

    /**
     * Returns a set view of the keys contained in the map
     * @return a Set of type K, of all keys in the hashmap
     */
    public Set<K> keySet()
    {
        return null;
    }

    /**
     * Outputs how many conflicts occur at each bin and list
     * the keys in that bin
     */
    public void printTable()
    {

    }

    /**
     * Associates a specified value with the specified key
     * @param key key for the key value pair
     * @param val value for the key value pair
     * @return the previous value associated with that key, or null
     *         if there never was a previously associated value
     */
    public V put(K key, V val)
    {
        V temp = null;
        if(this.containsKey(key))
        {
            temp = this.get(key);
            this.remove(key);
        }
        this.hashTable.put(key,val);
        return temp;
    }

    /**
     * Removes the mapping for the specified key from this map
     * if present
     * @param key key for which to remove mapping
     * @return the previous value associated with that key, or null
     *         if there never was a previously associated value. In
     *         this case that would be the value we just removed.
     */
    public V remove (K key)
    {
        return null;
    }

    /**
     * Returns the size of the hashmap
     * @return int
     */
    public int size()
    {
        int size = 0;
        for(LinkedList linkedList:this.hashTable.hashTable)
            size+=linkedList.size();
        return size;
    }

    //Internal classes
    private class Node<K,V>
    {
        K key;
        V value;
        public Node(K key, V value)
        {
            this.key=key;
            this.value=value;
        }
    }

    private class HashTable<K,V>
    {
        /**
         * This field is locked to 8 for the purposes of the project,
         * it could just as easily be modified
         */
        private final static int TABLE_SIZE = 8;
        ArrayList<LinkedList< Node<K,V>>> hashTable = new ArrayList<>(TABLE_SIZE);

        public HashTable()
        {
            for (int i = 0; i < TABLE_SIZE; i++)
                hashTable.add(new LinkedList<Node<K,V>>());
        }

        private int h(K key) {
            int hashCode = key.hashCode();
            int index = hashCode % TABLE_SIZE;
            return Math.abs(index);
        }

        //TODO: Update linking method here
        public void put(K key, V value)
        {
            int index = h(key);
            Node<K, V> node = new Node<>(key, value);
            hashTable.get(index).add(node);
        }

        public V get(K key)
        {
            int index = h(key);

            LinkedList<Node<K,V>> list = hashTable.get(index);
            for (Node<K,V> n: list)
                if (n.key.equals(key))
                    return n.value;

            return null;
        }

        public boolean contains(K key) {
            V value = get(key);
            return value == null ? false : true;
        }

        public String toString()
        {
            String str = "";
            for (int i = 0; i < TABLE_SIZE; i++)
            {
                str += i + ": [";
                LinkedList<Node<K,V>> list = hashTable.get(i);

                for(int j = 0; j < list.size(); j++)
                    str += list.get(j).key + ", ";

                str += "]\n";
            }
            return str;
        }
    }

}
