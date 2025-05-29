package algorithm_template;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<T> {
    private static final int DEFAULT_CAPACITY = 10;

    // 堆的存储数组
    private Object[] heap;

    // 堆的当前元素数量
    private int size;

    // 比较器
    private final Comparator<? super T> comparator;

    // 构造方法：初始化堆容量和比较器
    public Heap(Comparator<? super T> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public Heap(int capacity, Comparator<? super T> comparator) {
        this.heap = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * 插入元素
     */
    public void insert(T element) {
        // 1.检查扩容
        if (size == heap.length) {
            resizeHeap();
        }

        // 2.将新元素添加到数组末尾
        heap[size] = element;

        // 3. 上浮调整堆结构
        shiftUp(size);
        size++;
    }

    /**
     * 移除堆顶元素
     */
    public T poll() {
        System.out.println(Thread.currentThread().getName());
        if (size == 0) {
            return null;
        }

        // 1. 保存堆顶元素
        T root = (T) heap[0];

        // 2. 将末尾元素移到堆顶
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        // 3. 下沉调整堆结构
        shiftDown(0);

        return root;
    }

    /**
     * 获取堆顶元素（不移除）
     */
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return (T) heap[0];
    }

    /**
     * 扩容堆数组（容量翻倍）
     */
    private void resizeHeap() {
        int newCapacity = heap.length * 2;
        heap = Arrays.copyOf(heap, newCapacity);
    }

    /**
     * 上浮操作（从下往上调整）
     */
    private void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            // 比较当前节点与父节点的值
            if (comparator.compare((T) heap[index], (T) heap[parent]) > 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // 下沉操作（从上往下调整）
    private void shiftDown(int index) {
        int maxIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // 找出父节点、左右子节点中的极值（大根堆找最大，小根堆找最小）
        if (leftChild < size && comparator.compare((T) heap[leftChild], (T) heap[maxIndex]) > 0) {
            maxIndex = leftChild;
        }
        if (rightChild < size && comparator.compare((T) heap[rightChild], (T) heap[maxIndex]) > 0) {
            maxIndex = rightChild;
        }

        // 如果父节点不是极值，交换并递归调整
        if (maxIndex != index) {
            swap(index, maxIndex);
            shiftDown(maxIndex);
        }
    }

    // 交换数组中的两个元素
    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int size() {
        return size;
    }

    // 测试代码
    public static void main(String[] args) {
        // 大根堆（比较器返回 a - b）
        Heap<Integer> maxHeap = new Heap<>((a, b) -> a - b);

        // 小根堆测试（比较器返回 b - a）
        Heap<Integer> minHeap = new Heap<>((a, b) -> b - a);

        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(5);
        System.out.println("大根堆堆顶" + maxHeap.peek()); // 输出5

        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(5);
        System.out.println("小根堆堆顶: " + minHeap.peek()); // 输出1

        // 删除操作测试
        maxHeap.poll();
        System.out.println("删除后大根堆堆顶: " + maxHeap.peek()); // 输出3
    }
}
