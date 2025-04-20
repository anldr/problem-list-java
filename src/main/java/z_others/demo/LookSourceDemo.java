package z_others.demo;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;

public class LookSourceDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
        HashMap<Integer,String> map = new HashMap<>();
        ConcurrentHashMap<String, String> ppp = new ConcurrentHashMap<>();
        Vector<Integer> v1 = new Vector<>();
        CopyOnWriteArrayList<Integer> cpy;
        FutureTask<String> futureTask = new FutureTask<>(new Task());
        Thread thread = new Thread(futureTask);

        futureTask.run();

    }

    static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            // 线程任务代码
            return "Task result";
        }
    }
}
