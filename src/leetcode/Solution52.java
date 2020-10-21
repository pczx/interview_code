package leetcode;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            for (int i = lenA - lenB; i > 0; i--) {
                currA = currA.next;
            }
        } else {
            for (int i = lenB - lenA; i > 0; i--) {
                currB = currB.next;
            }
        }
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}