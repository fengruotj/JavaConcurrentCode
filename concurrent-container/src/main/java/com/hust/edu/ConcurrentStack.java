package com.hust.edu;

import java.util.concurrent.atomic.AtomicReference;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/13.
 */
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> top=new AtomicReference<>();

    public void push(E item){
        Node<E> newHead=new Node<>(item);
        Node<E> oldValue;
        do{
            oldValue=top.get();
            newHead.netxt=oldValue;
        }while (!top.compareAndSet(oldValue,newHead));
    }

    public E top(){
        Node<E> newHead;
        Node<E> oldHead;
        do{
            oldHead=top.get();
            if(oldHead==null)
                return null;
            newHead=oldHead.netxt;
        }while (!top.compareAndSet(oldHead,newHead));
        return oldHead.item;
    }

    public static class Node<E>{
        private final E item;
        private Node<E> netxt;

        public Node(E item) {
            this.item = item;
        }
    }
}
