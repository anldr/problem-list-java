package leetcode.Vol1to100;

public class LeetCode8 {
    class Solution {
        public int myAtoi(String s) {
            int flag = 1;
            int index = 0;
            while (index < s.length()) {
                if (s.charAt(index) == ' ') {
                    index++;
                } else if (s.charAt(index) == '-'){
                    index++;
                    flag = -1;
                    break;
                } else if (s.charAt(index) == '+'){
                    index++;
                    break;
                } else {
                    break;
                }
            }
            long result = 0L;
            while (index < s.length()) {
                long temp = Math.abs(result);
                if (isNum(s.charAt(index))) {
                    temp = temp * 10 + s.charAt(index) - '0';
                    index++;
                } else {
                    break;
                }

                if (temp * flag < Integer.MIN_VALUE) {
                    result = Integer.MIN_VALUE;
                } else if (temp * flag > Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                } else {
                    result = temp * flag;
                }
            }

            return (int)result;
        }

        private boolean isNum(char c) {
            return c <= '9' && c >= '0';
        }
    }
}
