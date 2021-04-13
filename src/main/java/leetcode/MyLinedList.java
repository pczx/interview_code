package leetcode;

class MyLinkedList {

    private class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    private Node tail;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return -1;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail.prev.next;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }


    public void addAtIndex(int index, int val) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return;
            }
        }
        Node node = new Node(val);
        node.next = cur.next;
        node.prev = cur;
        cur.next.prev = node;
        cur.next = node;
    }

    public void deleteAtIndex(int index) {
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return;
            }
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    public static void main(String[] args) {
        System.out.println(0 << 1);
    }
}