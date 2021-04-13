package leetcode;

public class leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int n = 1;
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next, n++);
        if (k % n == 0) {
            return head;
        }
        cur = head;
        ListNode old_tail = head;
        for (int i = 0; i < k % n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            old_tail = old_tail.next;
        }
        ListNode new_Head = old_tail.next;
        old_tail.next = null;
        cur = new_Head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return new_Head;
    }


    public static void main(String[] args) {
        new leetcode61().rotateRight(new ListNode(1, null), 1);
    }
}
