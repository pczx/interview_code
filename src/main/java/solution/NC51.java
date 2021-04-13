package solution;

import jianzhioffer.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NC51 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode head = null, cur = null;
        PriorityQueue<ListNode> hq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                hq.offer(node);
            }
        }
        while (!hq.isEmpty()) {
            ListNode first = hq.poll();
            if (head == null) {
                head = new ListNode(first.val);
                cur = head;
            } else {
                cur.next = new ListNode(first.val);
                cur = cur.next;
            }
            first = first.next;
            if (first != null) {
                hq.add(first);
            }
        }
        return head;
    }
}
