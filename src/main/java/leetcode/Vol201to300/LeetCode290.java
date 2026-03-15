package leetcode.Vol201to300;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] sList = s.split(" ");
        if (n != sList.length) {
            return false;
        }

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if (p2s.containsKey(ch) && !p2s.get(ch).equals(sList[i])
                || s2p.containsKey(sList[i]) && s2p.get(sList[i]) != ch) {
                return false;
            }
            p2s.put(ch, sList[i]);
            s2p.put(sList[i], ch);
        }

        return true;
    }
}
