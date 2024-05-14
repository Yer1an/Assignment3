import java.util.*;

public class BST<K extends Comparable<K>,V> implements Iterable<BST<K, V>.Node>{
    private Node root;
    private int size;
    public class Node{
        private K key;
        private V val;
        private Node left,right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
    public void put(K key, V val){
        root = put(root, key, val);
        size++;
    }
    private Node put(Node node, K key, V val){
        if(node == null) return new Node(key,val);
        int comparison = key.compareTo(node.key);
        if(comparison > 0) {
            node.right = put(node.right, key, val);
        }else if(comparison < 0){
            node.left = put(node.left, key, val);
        }else{
            node.val = val;
        }
        return node;
    }

    public V get(K key){
        return get(root, key);
    }
    private V get(Node node, K key){
        if(node == null) return null;
        int comparison = key.compareTo(node.key);
        if(comparison < 0) {
            return get(node.left, key);
        }else if(comparison > 0) {
            return get(node.right, key);
        }else{
            return node.val;
        }
    }
    public void delete(K key){
        root = delete(root,key);
        size--;
    }
    private Node delete(Node node,K key){
        if(node == null) return null;
        int comparison = key.compareTo(node.key);
        if(comparison < 0){
            node.left = delete(node.left, key);
        }else if(comparison > 0){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;

        }
        return node;
    }

    private Node min(Node node){
        if(node.left == null) return node;
        else return min(node.left);
    }
    private Node deleteMin(Node node){
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    @Override
    public Iterator<Node> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Node> {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            pushLeft(node.right);
            return node;
        }
    }
    private void inorder(Node node, ArrayList<K> keys){
        if(node == null) return;
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }
    public int size(){
        return size;
    }
}
