package leetcode.Vol1to100;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Set<Character> setChar = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            while (setChar.contains(s.charAt(right))) {
                setChar.remove(s.charAt(left));
                left++;
            }
            setChar.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
