package leetcode.Vol501to600;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> allItem = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            allItem.add(new int[]{capital[i], profits[i]});
        }
        allItem.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pQue = new PriorityQueue<>((a, b) -> b - a);

        int idx = 0;
        for (int i = 1; i <= k ; i++) {
            while (idx < profits.length && allItem.get(idx)[0] <= w) {
                pQue.add(allItem.get(idx)[1]);
                idx++;
            }
            if (pQue.isEmpty()) {
                break;
            }
            w += pQue.poll();
        }

        return w;
    }

    private static class Item {
        private int profits;

        private int capital;

        public Item() {

        }

        public Item(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }
}
