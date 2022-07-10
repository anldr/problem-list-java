package leetcode.Vol501to600;

import java.util.ArrayList;
import java.util.List;

public class LeetCode556 {
    static class Solution {
        public int nextGreaterElement(int n) {
            int x = n;
            List<Integer> num = new ArrayList<>();

            while (x > 0) {
                num.add(x % 10);
                x = x / 10;
            }

            int pre = -1, val = -1, pos = -1;
            for (int i = 0; i < num.size(); i++) {
                if (pre > num.get(i)) {
                    val = num.get(i);
                    pos = i;
                    break;
                }
                pre = num.get(i);
            }

            if (pos == -1) {
                return -1;
            }

            for (int i = 0; i < num.size(); i++) {
                if (num.get(i) > val) {
                    swap(num, i, pos);
                    break;
                }
            }

            for (int i = pos - 1, j = 0; i >= j; i--, j++) {
                swap(num, i, j);
            }

            long result = 0;
            for (int i = num.size() - 1; i >= 0; i--) {
                result = result * 10 + num.get(i);
            }
            return result > Integer.MAX_VALUE ? -1 : (int)result;
        }

        public void swap(List<Integer> num, int i, int j) {
            int temp = num.get(i);
            num.set(i, num.get(j));
            num.set(j, temp);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.nextGreaterElement(12);
    }
}
