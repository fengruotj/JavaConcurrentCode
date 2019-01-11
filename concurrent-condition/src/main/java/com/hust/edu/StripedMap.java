package com.hust.edu;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/11.
 */
public class StripedMap {
    private static final int N_LOCKs=16;
    private final Node[] buckets;
    private final Object[] locks;

    public StripedMap(int numBuckets) {
        this.buckets = new Node[numBuckets];
        locks = new Object[N_LOCKs];
        for (int i = 0; i < N_LOCKs; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key){
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key){
        int hash = hash(key);
        Object lock = locks[hash % N_LOCKs];
        synchronized (lock){
            for(Node m= buckets[hash]; m!=null; m=m.next){
                if(m.key.equals(key)){
                    return m.value;
                }
            }
        }
        return null;
    }

    public void clear(){
        for (int i = 0; i < buckets.length; i++) {
            Object lock = locks[i];
            synchronized (lock){
                buckets[i]=null;
            }
        }
    }

    private static class Node{
        private Object key;
        private Object value;
        public Node next;

        public Node() {
        }

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
