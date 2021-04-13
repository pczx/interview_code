package solution;

import jianzhioffer.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class NC50 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = head;

        while (cur != null) {
            ListNode end = cur;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(cur);
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return dummyNode.next;
    }


    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}