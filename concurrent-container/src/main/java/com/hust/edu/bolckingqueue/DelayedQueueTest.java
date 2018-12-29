package com.hust.edu.bolckingqueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class DelayedQueueTest {
    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(new DelayTask("1", new Date()));
        queue.add(new DelayTask("2", new Date(System.currentTimeMillis()+5000)));
        queue.add(new DelayTask("3", new Date(System.currentTimeMillis()+1000)));
        queue.add(new DelayTask("4", new Date(System.currentTimeMillis()+2000)));

        System.out.println("queue put done");

        while(!queue.isEmpty()) {
            try {
                DelayTask task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DelayTask implements Delayed {
        private String name;

        private Date taskTime;


        public DelayTask(String name, Date  taskTime) {
            this.name = name;
            this.taskTime = taskTime;
        }

        @Override
        public int compareTo( Delayed o) {
            DelayTask delayTask = (DelayTask) o;
            long diff = taskTime.getTime() - delayTask.getTaskTime().getTime();
            if (diff > 0) {
                return 1;
            } else if (diff == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(taskTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTaskTime() {
            return taskTime;
        }

        public void setTaskTime(Date taskTime) {
            this.taskTime = taskTime;
        }
    }
}
