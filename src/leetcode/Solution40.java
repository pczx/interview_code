package leetcode;

import java.util.*;

public class Solution40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];

        if (k == 0) {
            return arr;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

        //建立最大堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
