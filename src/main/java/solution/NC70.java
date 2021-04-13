package solution;

import jianzhioffer.ListNode;

public class NC70 {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        ListNode res = null;
        if (head == null) {
            return res;
        }
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(head2);
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}