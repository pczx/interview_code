package leetcode;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = getListLength(headA), lengthB = getListLength(headB);
        int lengthDif = lengthA - lengthB;
        ListNode headLong = headA;
        ListNode headShort = headB;

        if (lengthA < lengthB) {
            headLong = headB;
            headShort = headA;
            lengthDif = lengthB - lengthA;
        }


        for (int i = 0; i < lengthDif; i++) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }
        return headLong;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}