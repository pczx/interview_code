class Solution22 {
    int count = 0;
    ListNode ans = null;

    public ListNode getKthFromEnd(ListNode head, int k) {
       recursion(head, k);
       return ans;
    }

    private void recursion(ListNode head, int k) {
        if (head == null) return;
        recursion(head.next, k);
        count++;
        if (count == k) {
            ans = head;
        }
    }
}