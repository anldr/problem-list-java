package leetcode.Vol201to300;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        for (int i = 0 ; i < s.length(); i++) {
            num[t.charAt(i) - 'a']--;
            if (num[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
