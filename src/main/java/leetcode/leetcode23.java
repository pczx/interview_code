package leetcode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = null;
        ListNode cur = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head;
    }
}
