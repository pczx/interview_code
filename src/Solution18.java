class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode pre = dummy;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}