
public class MyHashTable<K, V>{
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key){
        return key.hashCode() % M;
    }
    public void put(K key,V value){
        int hash_index = hash(key);
        HashNode n = new HashNode<K,V>(key,value);
        if(chainArray[hash_index] == null){
            chainArray[hash_index] = n;
            return;
        }
        HashNode it = chainArray[hash_index];
        HashNode prev = it;
        while(it != null  && it.key != key){
            prev = it;
            it = it.next;
        }
        if(it == null){
            prev.next = n;
            size++;
        }else{
            it = n;
        }
    }
    public V get(K key){
        int hash_index = hash(key);
        if(chainArray[hash_index] == null){
            throw new RuntimeException("The node with this key isn't found");
        }
        HashNode temp = chainArray[hash_index];
        while(temp.key !=key && temp != null){
            temp = temp.next;
        }
        if(temp == null){
            throw new RuntimeException("No such element key-value pair in hash table");
        }
        return (V)temp.value;
    }
    public V remove(K key){
        int hash_index =  hash(key);
        HashNode it = chainArray[hash_index];
        if(chainArray[hash_index].key == key){
            V temp = chainArray[hash_index].value;
            chainArray[hash_index] = chainArray[hash_index].next;
            it.next = null;
            return temp;
        }
        HashNode prev = it;
        while(it.key != key && it != null){
            prev = it;
            it = it.next;
        }
        if(it == null) {
            return null;
        }else{
            V temp = (V)it.value;
            prev.next = null;
            size--;
            return temp;
        }
    }
    public boolean contains(V value){
        for(int i = 0; i < M; i++){
            HashNode it = chainArray[i];
            while(it != null){
                if(it.value == value){
                    return true;
                }
                it = it.next;
            }
        }
        return false;

    }
    public K getKey(V value){
        for(int i = 0; i < M; i++){
            HashNode it = chainArray[i];
            while(it != null){
                if(it.value == value){
                    return (K)it.key;
                }
                it = it.next;
            }
        }
        throw new RuntimeException("No such value in hashtable");
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return size;
    }
}
