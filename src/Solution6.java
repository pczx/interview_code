import java.util.*;

public class Solution6 {
    private ArrayList<Integer> ans = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
       recursive(head);
       return ans.stream().mapToInt(i -> i).toArray();
    }

    private void recursive(ListNode node) {
        if (node == null) {
            return;
        }
        recursive(node.next);
        ans.add(node.val);
    }
}
