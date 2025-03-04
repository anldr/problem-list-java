package algorithm_template;

public class CircularQueue<E> {
    private int front;

    private int rear;

    private final int capacity;

    private final E[] queue;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity + 1;
        this.queue = (E[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return this.front == (this.rear + 1) % this.capacity;
    }

    public boolean enQueue(E e) {
        if (isFull()) {
            return false;
        }

        this.queue[this.rear] = e;
        this.rear = this.rear + 1;

        return true;
    }

    public E deQueue() {
        if (isEmpty()) {
            return null;
        }

        E e = this.queue[this.front];
        this.front = this.front + 1;

        return e;
    }

    public E getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.queue[this.front];
    }

    public E getRear() {
        if (isEmpty()) {
            return null;
        }
        return this.queue[(this.rear - 1 + this.capacity) % this.capacity];
    }
}
