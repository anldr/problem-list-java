package leetcode.Vol1to100;

public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        int idx1 = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                idx1 = i;
                break;
            }
        }

        int result = 0;
        for (int i = idx1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
                continue;
            }
            break;
        }
        return result;
    }
}
