package leetcode.Vol201to300;

import java.util.HashMap;
import java.util.Map;

public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n ; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (st.containsKey(x) && st.get(x) != y || ts.containsKey(y) && ts.get(y) != x) {
                return false;
            }
            st.put(x, y);
            ts.put(y, x);
        }

        return true;
    }
}
