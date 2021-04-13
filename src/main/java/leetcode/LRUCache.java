package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        LinkedNode() {
            this(0, 0, null, null);
        }

        LinkedNode(int key, int value) {
            this(key, value, null, null);
        }

        LinkedNode(int key, int value, LinkedNode prev, LinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private LinkedNode head;
    private LinkedNode tail;
    private int capacity;
    private int size;
    private Map<Integer, LinkedNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new LinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            if (++size > capacity) {
                LinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}