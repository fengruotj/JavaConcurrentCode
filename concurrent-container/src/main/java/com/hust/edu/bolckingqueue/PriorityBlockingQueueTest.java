package com.hust.edu.bolckingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class PriorityBlockingQueueTest {
    //支持优先级的无界队列，可以不断的put因为支持扩容。但是当队列元素为空时，get操作就会阻塞。
    public static PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>(3);

    public static void main(String[] args) {
        queue.put(new User(1,"wu"));
        queue.put(new User(5,"wu5"));
        queue.put(new User(23,"wu23"));
        queue.put(new User(55,"wu55"));
        queue.put(new User(9,"wu9"));
        queue.put(new User(3,"wu3"));
        for (User user : queue) {
            try {
                System.out.println(queue.take().name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            User user = queue.take();
            System.out.println(user);
        } catch (InterruptedException e) {

        }
    }

    //静态内部类
    static class User implements Comparable<User>{

        public User(int age,String name) {
            this.age = age;
            this.name = name;
        }

        int age;
        String name;

        /**
         * 排序 o this
         * this compareTo o
         * @param o
         * @return
         */
        @Override
        public int compareTo(User o) {
            return this.age > o.age ? 1 : -1;
        }
    }
}
