package com.hust.edu;

import java.util.concurrent.*;

public class ConcurrentTask {

    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private ExecutorService executorService=Executors.newSingleThreadScheduledExecutor();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); //1.1,2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        //......
                        System.out.println("TaskName: "+taskName);
                        return taskName;
                    }
                };

                //1.2创建任务
                        FutureTask futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); //1.3
                if (future == null) {
                    future = futureTask;
                    executorService.submit(futureTask);
                }
            }

            try {
                return future.get(); //1.5,2.2线程在此等待任务执行完成
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }

    private void stop(){
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcurrentTask concurrentTask=new ConcurrentTask();
        concurrentTask.executionTask("1");
        concurrentTask.executionTask("2");
        concurrentTask.executionTask("3");
        concurrentTask.stop();
    }
}
