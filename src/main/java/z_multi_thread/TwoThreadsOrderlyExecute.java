package z_multi_thread;

import java.util.BitSet;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadsOrderlyExecute {
    private static final Object lock = new Object();

    private static Integer printNumber = 1;

    private static Integer MaxNumber = 100;

    // 主线程
    public static void main(String[] args) throws InterruptedException {
        Thread odd = new Thread(new OddPrinterV4());
        Thread even = new Thread(new EvenPrinterV4());

        odd.start();
        even.start();
    }

    /**
     * wait/notify机制
     */
    private static class OddPrinterV1 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                synchronized (lock) {
                    if ((printNumber & 1) == 1) {
                        System.out.println(printNumber++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    private static class EvenPrinterV1 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                synchronized (lock) {
                    if ((printNumber & 1) == 0) {
                        System.out.println(printNumber++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    private static final Semaphore oddSemaphore = new Semaphore(1);

    private static final Semaphore evenSemaphore = new Semaphore(0);

    /**
     * semaphore机制
     */
    private static class OddPrinterV2 implements Runnable {
        @Override
        public void run() {
            while (printNumber < MaxNumber) {
                try {
                    oddSemaphore.acquire();
                    if ((printNumber & 1) == 1) {
                        System.out.println(printNumber++);
                        evenSemaphore.release();
                    } else {
                        oddSemaphore.release();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class EvenPrinterV2 implements Runnable {
        @Override
        public void run() {
            while (printNumber < MaxNumber) {
                try {
                    evenSemaphore.acquire();
                    if ((printNumber & 1) == 0) {
                        System.out.println(printNumber++);
                        oddSemaphore.release();
                    } else {
                        evenSemaphore.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static final Lock rLock = new ReentrantLock();

    private static final Condition oddCondition = rLock.newCondition();

    private static final Condition evenCondition = rLock.newCondition();

    /**
     * ReentrantLock/Condition机制
     */
    private static class OddPrinterV3 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                rLock.lock();
                try {
                    if ((printNumber & 1) == 1) {
                        System.out.println(printNumber++);
                        evenCondition.signalAll();
                    } else {
                        oddCondition.await();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    rLock.unlock();
                }
            }
        }
    }

    private static class EvenPrinterV3 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                rLock.lock();
                try {
                    if ((printNumber & 1) == 0) {
                        System.out.println(printNumber++);
                        oddCondition.signalAll();
                    } else {
                        evenCondition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    rLock.unlock();
                }
            }
        }
    }

    private static boolean printOdd = true;

    /**
     * Thread.yield()机制，这个机制存疑
     */
    private static class OddPrinterV4 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                while (!printOdd) {
                    Thread.yield();
                }
                if (printNumber <= MaxNumber) {
                    System.out.println(printNumber++);
                }
                printOdd = false;
                Thread.yield();
            }
        }
    }

    private static class EvenPrinterV4 implements Runnable {
        @Override
        public void run() {
            while (printNumber <= MaxNumber) {
                while (printOdd) {
                    Thread.yield();
                }
                if (printNumber <= MaxNumber) {
                    System.out.println(printNumber++);
                }
                printOdd = true;
                Thread.yield();
            }
        }
    }
}
