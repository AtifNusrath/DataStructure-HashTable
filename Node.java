package org.bridgelabz;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V> next;


    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public Node<K, V> getNext() {
        return next;
    }
    public void setNext(Node<K, V> next) {
        this.next = next;
    }
    public Node(K key, V value) {
        super();
        this.key = key;
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node[" + "key=" + key + ", value=" + value + ", next=" + next + ']';
    }

}
