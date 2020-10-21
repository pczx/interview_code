package leetcode;

class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}