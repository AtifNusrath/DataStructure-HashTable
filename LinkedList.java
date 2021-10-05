package org.bridgelabz;

import java.util.ArrayList;

public class LinkedList<K, V> {
    Node head;
    Node tail;
    int size;
    private final int numOfBuckets;
    ArrayList<Node<K, V>> myBucketArray;

    public LinkedList() {
        this.numOfBuckets = 20;
        myBucketArray = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++) {
            myBucketArray.add(null);
        }
    }


    public void add(K key, V value) {
        int index = getKeyIndex(key);
        Node<K, V> node = myBucketArray.get(index);
        if (node == null) {
            node = new Node<>(key, value);
            myBucketArray.set(index, node);
        }
        node = searchNode(key);
        if (node == null) {
            node = new Node<>(key, value);
            append(node);

        } else {
            node.setValue(value);
        }
    }

    private void append(Node<K, V> node) {
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

    }



    public V get(K key)
    {
        int index=getKeyIndex(key);
        Node<K, V> head=myBucketArray.get(index);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
   public Node<K, V> searchNode(K key) {
        Node node = head;
        int countposition = 0;
        while (node != null) {
            countposition++;
            if (node.getKey().equals(key)) {
                return node;
            }
            node = node.getNext();
        }
        return node;
    }


    public int getKeyIndex(K word) {
        int hashcode = Math.abs(word.hashCode());
        int index = hashcode % numOfBuckets;
        return index;

    }

    public V remove(K word)
    {
        int index=getKeyIndex(word);
        Node<K, V>head=myBucketArray.get(index);
        if(head==null)
        {
            return null;
        }
        if(head.key.equals(word))
        {
            V val=head.value;
            head=head.next;
            myBucketArray.set(index, head);
            size--;
            return val;
        }
        else
        {
            Node<K, V>prev=null;
            while(head!=null)
            {
                if(head.key.equals(word))
                {
                    prev.next=head.next;
                    size--;
                    System.out.println("Remove: "+prev+" : "+head.value);

                    return head.value;
                }
                prev=head;
                head=head.next;
            }
            return null;
        }
    }

    public String toString() {
        return "Mylist{" + head + "}";
    }
}
