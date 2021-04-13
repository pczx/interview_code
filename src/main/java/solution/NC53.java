package solution;

import jianzhioffer.ListNode;

public class NC53 {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        for (int i = 0; i < n - 1; i++) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }

        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
