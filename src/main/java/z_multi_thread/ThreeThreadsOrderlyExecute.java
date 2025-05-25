package z_multi_thread;

import java.util.concurrent.*;

/**
 * 三个线程严格按照顺序执行
 */
public class ThreeThreadsOrderlyExecute {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, ExecutionException {
        method5();
    }

    private static void method1() {
        final Thread thread1 = new Thread(() -> System.out.println("1..."));

        final Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2...");
        });

        final Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3...");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void method2() throws InterruptedException {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);

        MyThread thread1 = new MyThread(latch1, "thread1");
        MyThread thread2 = new MyThread(latch2, "thread2");
        MyThread thread3 = new MyThread(latch3, "thread3");

        thread1.start();
        latch1.await();

        thread2.start();
        latch2.await();

        thread3.start();
        latch3.await();
    }

    private static void method3() throws InterruptedException, BrokenBarrierException {
        CyclicBarrier barrier = new CyclicBarrier(2);

        MyThread2 thread1 = new MyThread2(barrier, "thread1");
        MyThread2 thread2 = new MyThread2(barrier, "thread2");
        MyThread2 thread3 = new MyThread2(barrier, "thread3");

        thread1.start();
        barrier.await();

        thread2.start();
        barrier.await();

        thread3.start();
        barrier.await();
    }

    private static void method4() throws InterruptedException, BrokenBarrierException {
        Semaphore semaphore = new Semaphore(1);

        semaphore.acquire();
        MyThread3 thread1 = new MyThread3(semaphore, "thread1");
        thread1.start();

        semaphore.acquire();
        MyThread3 thread2 = new MyThread3(semaphore, "thread2");
        thread2.start();

        semaphore.acquire();
        MyThread3 thread3 = new MyThread3(semaphore, "thread3");
        thread3.start();
    }

    private static void method5() throws ExecutionException, InterruptedException {
        final Thread thread1 = new Thread(() -> System.out.println("1..."));
        final Thread thread2 = new Thread(() -> System.out.println("2..."));
        final Thread thread3 = new Thread(() -> System.out.println("3..."));

        CompletableFuture<Void> future = CompletableFuture.runAsync(thread1)
                        .thenRun(thread2).thenRun(thread3);

        future.get();
    }

    static class MyThread3 extends Thread {
        private Semaphore semaphore;

        public MyThread3(Semaphore semaphore, String name) {
            super();
            this.semaphore = semaphore;
            setName(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                semaphore.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class MyThread2 extends Thread {
        private CyclicBarrier barrier;

        public MyThread2(CyclicBarrier barrier, String name) {
            super();
            this.barrier = barrier;
            setName(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class MyThread extends Thread {
        private CountDownLatch latch;

        public MyThread(CountDownLatch latch, String name) {
            super();
            this.latch = latch;
            setName(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running...");
            latch.countDown();
        }
    }
}
