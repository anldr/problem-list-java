package leetcode.Vol201to300;

import java.util.HashMap;
import java.util.Map;

public class LeetCode274 {
    public int hIndex(int[] citations) {
        int maxH = citations.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0 ; i < citations.length; i++) {
            countMap.put(Math.min(citations[i], maxH), countMap.getOrDefault(Math.min(citations[i], maxH), 0) + 1);
        }

        int sum = 0;
        for (int i = maxH; i > 0; i--) {
            sum = sum + countMap.getOrDefault(i, 0);
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
