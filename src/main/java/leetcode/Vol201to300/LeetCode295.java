package leetcode.Vol201to300;

import java.util.PriorityQueue;

public class LeetCode295 {
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianFinder() {
            this.left = new PriorityQueue<>((a, b) -> b - a);
            this.right = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                right.add(num);
                left.add(right.poll());
            } else {
                left.add(num);
                right.add(left.poll());
            }
        }

        public double findMedian() {
            return left.size() == right.size() ? (left.peek() + right.peek()) / 2.0 : 1.0 * left.peek();
        }
    }
}
