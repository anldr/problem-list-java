package z_others;

public class CirQueue {
    private int capacity;

    private int[] queue;

    private int head;

    private int tail;

    public CirQueue() {

    }

    public CirQueue(int capacity) {
        this.capacity = capacity + 1;
        this.queue = new int[this.capacity];
        this.head = 0;
        this.tail = 0;
    }

    public boolean push(int val) {
        if (is_full()) {
            return false;
        }

        this.queue[tail] = val;
        tail = (tail + 1) % capacity;
        return true;
    }

    public boolean pop() {
        if (is_empty()) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    public int front() {
        if (is_empty()) {
            return -1; // 表示不存在元素
        }
        return queue[head];
    }

    public int back() {
        if (is_empty()) {
            return -1;
        }
        return queue[(tail - 1 + capacity) % capacity];
    }

    public boolean is_full() {
        return ((tail + 1) % capacity) == head;
    }

    public boolean is_empty() {
        return head == tail;
    }
}
