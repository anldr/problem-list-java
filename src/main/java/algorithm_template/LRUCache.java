package algorithm_template;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    int curSize;
    int capacity;
    DoubleLinkNode<K, V> head;
    DoubleLinkNode<K, V> tail;
    Map<K, DoubleLinkNode<K, V>> cache;

    public LRUCache(int capacity) {
        this.curSize = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkNode<>();
        this.tail = new DoubleLinkNode<>();
        this.head.nextNode = tail;
        this.tail.preNode = head;
        cache = new HashMap<>();
    }

    public V get(K key) {
        DoubleLinkNode<K, V> result = cache.getOrDefault(key, null);
        if (result == null) {
            return null;
        }
        moveToHead(result);
        return result.value;
    }

    public synchronized void put(K key, V value) {
        DoubleLinkNode<K, V> result = cache.getOrDefault(key, null);
        if (result == null) {
            DoubleLinkNode<K, V> newNode = new DoubleLinkNode<>(key, value);
            ++curSize;
            if (cache.size() > capacity) {
                DoubleLinkNode<K, V> tailNode = deleteTail();
                cache.remove(tailNode.key);
                curSize--;
            }
            cache.put(key, newNode);
            addToHead(newNode);
        } else {
            result.value = value;
            moveToHead(result);
        }
    }

    private void moveToHead(DoubleLinkNode<K, V> node) {
        deleteNode(node);
        addToHead(node);
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

    private DoubleLinkNode<K, V> deleteTail() {
        DoubleLinkNode<K, V> result = this.tail.preNode;
        deleteNode(result);
        return result;
    }

    private static class DoubleLinkNode<K, V> {
        K key;
        V value;
        DoubleLinkNode<K, V> preNode;
        DoubleLinkNode<K, V> nextNode;

        public DoubleLinkNode() {

        }

        public DoubleLinkNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
