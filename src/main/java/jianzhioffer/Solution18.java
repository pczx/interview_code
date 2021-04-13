package jianzhioffer;

class Solution18 {
    /*
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead, curr = newHead.next;
        while (curr != null) {
           if (curr.val == val) {
               pre.next = curr.next;
               break;
           }
           pre = curr;
           curr = curr.next;
        }
        return newHead.next;
    }
    */

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}