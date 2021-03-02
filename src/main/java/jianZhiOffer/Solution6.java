package jianZhiOffer;

import java.util.Stack;

public class Solution6 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}
