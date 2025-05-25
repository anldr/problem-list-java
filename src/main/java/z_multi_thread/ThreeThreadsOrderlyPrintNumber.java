package z_multi_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadsOrderlyPrintNumber {
    private static final Object lock = new Object();

    private static volatile int printNum = 0;

    public static void main(String[] args) {
        method2();
    }

    private static void method1() {
        Thread thread1 = new Thread(new Task(0));
        Thread thread2 = new Thread(new Task(1));
        Thread thread3 = new Thread(new Task(2));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static final ReentrantLock RELOCK = new ReentrantLock();

    private static void method2() {
        List<Condition> conditionList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Condition temp = RELOCK.newCondition();
            conditionList.add(temp);
        }

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new OrderlyTask(i, conditionList));
            thread.start();
        }
    }

    private static class OrderlyTask implements Runnable {
        private int index;

        private List<Condition> conditionList;

        public OrderlyTask(int index, List<Condition> conditionList) {
            super();
            this.index = index;
            this.conditionList = conditionList;
        }

        @Override
        public void run() {
            while (printNum <= 100) {
                try {
                    RELOCK.lock();
                    if ((printNum % 3) != index) {
                        conditionList.get(index).await();
                    }
                    if (printNum <= 100) {
                        System.out.println(printNum);
                        printNum++;
                    }
                    signal();
                } catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    RELOCK.unlock();
                }
            }
        }

        private void signal() {
            conditionList.get((index + 1) % 3).signal();
        }
    }

    private static class Task implements Runnable {
        private final int modNum;

        public Task(int modNum) {
            super();
            this.modNum = modNum;
        }

        @Override
        public void run() {
            while (printNum <= 100) {
                synchronized (lock) {
                    try {
                        while (printNum <= 100 && (printNum % 3) != modNum) {
                            lock.wait();
                        }
                        if (printNum <= 100) {
                            System.out.println(printNum);
                            printNum++;
                        }
                        lock.notifyAll();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
