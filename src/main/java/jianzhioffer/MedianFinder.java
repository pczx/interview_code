package jianzhioffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> maxHeap;

    private Queue<Integer> minHeap;
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            if (maxHeap.size() > 0 && maxHeap.peek() > num) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if (minHeap.size() > 0 && minHeap.peek() < num) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        double ans = 0;
        if ((size % 2) == 1) {
            ans = minHeap.peek();
        } else {
            ans = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return ans;
    }
}
