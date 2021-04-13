package jianzhioffer;

class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head, prev = null, reversedHead = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reversedHead = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversedHead;
    }
}