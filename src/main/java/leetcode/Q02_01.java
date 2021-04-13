package leetcode;

import java.util.HashSet;

public class Q02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pre = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            if (occurred.add(cur.val)) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        pre.next = null;
        return head;
    }

}
