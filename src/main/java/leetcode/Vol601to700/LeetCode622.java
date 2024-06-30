package leetcode.Vol601to700;

/**
 * 循环队列
 * MyCircularQueue
 */
public class LeetCode622 {
    private int capacity;

    private int[] queue;

    private int head;

    private int tail;

    public LeetCode622(int k) {
        this.head = 0;
        this.tail = 0;
        this.capacity = k + 1;
        this.queue = new int[this.capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.queue[this.tail] = value;
        this.tail = (this.tail + 1) % this.capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.head = (this.head + 1) % this.capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[(this.tail - 1 + this.capacity) % this.capacity];
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return ((this.tail + 1) % this.capacity) == this.head;
    }
}
