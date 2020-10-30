package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
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
        double result;
        if ((size & 1) == 1) {
            result = minHeap.peek();
        } else {
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */