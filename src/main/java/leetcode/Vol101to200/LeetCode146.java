package leetcode.Vol101to200;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    int curSize;
    int capacity;
    DoubleLinkNode head;
    DoubleLinkNode tail;
    Map<Integer, DoubleLinkNode> cache;

    public LeetCode146(int capacity) {
        this.curSize = 0;
        cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new DoubleLinkNode();
        this.tail = new DoubleLinkNode();
        this.head.nextNode = tail;
        this.tail.preNode = head;
    }

    public int get(int key) {
        DoubleLinkNode result = cache.getOrDefault(key, null);
        if (result == null) {
            return -1;
        }
        moveToHead(result);
        return result.value;
    }

    public void put(int key, int value) {
        DoubleLinkNode result = cache.getOrDefault(key, null);
        if (result == null) {
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            ++curSize;
            if (cache.size() > capacity) {
                DoubleLinkNode tailNode = deleteTail();
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

    private void moveToHead(DoubleLinkNode node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(DoubleLinkNode node) {
        node.preNode = this.head;
        node.nextNode = this.head.nextNode;
        this.head.nextNode.preNode = node;
        this.head.nextNode = node;
    }

    private void deleteNode(DoubleLinkNode node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    private DoubleLinkNode deleteTail() {
        DoubleLinkNode result = this.tail.preNode;
        deleteNode(result);
        return result;
    }

    private static class DoubleLinkNode {
        int key;
        int value;
        DoubleLinkNode preNode;
        DoubleLinkNode nextNode;

        public DoubleLinkNode() {

        }

        public DoubleLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
