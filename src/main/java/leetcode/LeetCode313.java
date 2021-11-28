package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> numSet = new HashSet<>();
        PriorityQueue<Long> integerPriorityQueue = new PriorityQueue<>();
        numSet.add(1L);
        integerPriorityQueue.add(1L);
        while ((--n) > 0) {
            long num = integerPriorityQueue.poll();
            for (int prime : primes) {
                long temp = prime * num;
                if (!numSet.contains(temp)) {
                    numSet.add(temp);
                    integerPriorityQueue.add(temp);
                }
            }
        }
        return integerPriorityQueue.poll().intValue();
    }
}
