package solution;

import jianzhioffer.ListNode;

public class NC21 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        ListNode firstNode = pre;
        ListNode new_tail = pre.next;
        for (int i = 0; i < n - m + 1; i++) {
            pre = pre.next;
        }
        ListNode second = pre.next;
        pre.next = null;
        firstNode.next = reverse(new_tail);
        new_tail.next = second;
        return dummyHead.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
