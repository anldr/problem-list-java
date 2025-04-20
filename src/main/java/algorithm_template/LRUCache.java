package algorithm_template;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> {
    private final int capacity;
    private final DoubleLinkNode<K, V> head;
    private final DoubleLinkNode<K, V> tail;
    private final Map<K, DoubleLinkNode<K, V>> cache;
    private final ReentrantReadWriteLock.ReadLock  rLock;
    private final ReentrantReadWriteLock.WriteLock wLock;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DoubleLinkNode<>(null, null);
        this.tail = new DoubleLinkNode<>(null, null);
        this.head.nextNode = tail;
        this.tail.preNode = head;
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        this.rLock = lock.readLock();
        this.wLock = lock.writeLock();
    }

    public V get(K key) {
        try {
            rLock.lock();
            DoubleLinkNode<K, V> result = cache.getOrDefault(key, null);
            if (result == null) {
                return null;
            }
            moveToHead(result);
            return result.value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
        }
    }

    public void put(K key, V value) {
        try {
            wLock.lock();
            DoubleLinkNode<K, V> result = cache.getOrDefault(key, null);
            if (result == null) {
                if (cache.size() >= capacity) {
                    DoubleLinkNode<K, V> tailNode = deleteTail();
                    cache.remove(tailNode.key);
                }
                DoubleLinkNode<K, V> newNode = new DoubleLinkNode<>(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
            } else {
                result.value = value;
                moveToHead(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            wLock.unlock();
        }
    }

    private void moveToHead(DoubleLinkNode<K, V> node) {
        deleteNode(node);
        addToHead(node);
    }

    private DoubleLinkNode<K, V> deleteTail() {
        DoubleLinkNode<K, V> result = this.tail.preNode;
        deleteNode(result);
        return result;
    }

    private void addToHead(DoubleLinkNode<K, V> node) {
        node.preNode = this.head;
        node.nextNode = this.head.nextNode;
        this.head.nextNode.preNode = node;
        this.head.nextNode = node;
    }

    private void deleteNode(DoubleLinkNode<K, V> node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    private static class DoubleLinkNode<K, V> {
        private final K key;
        private volatile V value;
        private volatile DoubleLinkNode<K, V> preNode;
        private volatile DoubleLinkNode<K, V> nextNode;

        public DoubleLinkNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.preNode = null;
            this.nextNode = null;
        }
    }
}
