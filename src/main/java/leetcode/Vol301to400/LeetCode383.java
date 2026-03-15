package leetcode.Vol301to400;

import java.util.HashSet;
import java.util.Set;

public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        int[] chSet = new int[26];
        for (char ch : chars) {
            chSet[ch - 'a']++;
        }

        char[] noteChars = ransomNote.toCharArray();
        for (char ch : noteChars) {
            if (chSet[ch - 'a'] <= 0) {
                return false;
            }
            chSet[ch - 'a']--;
        }

        return true;
    }
}
