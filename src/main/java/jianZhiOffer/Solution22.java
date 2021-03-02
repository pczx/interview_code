package jianZhiOffer;

class Solution22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode ahead = head;
        for (int i = 1; i < k; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                return null;
            }
        }
        ListNode behind = head;
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}