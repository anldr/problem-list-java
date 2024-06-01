package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class LeetCode17 {
    private final Map<Character, String> mapping = new HashMap<Character, String>() {{
       put('2', "abc");
       put('3', "def");
       put('4', "ghi");
       put('5', "jkl");
       put('6', "mno");
       put('7', "pqrs");
       put('8', "tuv");
       put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return result;
        }

        dfs(result, digits, 0, new StringBuilder(""));
        return result;
    }

    private void dfs(List<String> result, String digits, int idx, StringBuilder curString) {
        if (idx >= digits.length()) {
            result.add(curString.toString());
            return ;
        }

        String chars = mapping.get(digits.charAt(idx));
        StringBuilder sb = new StringBuilder(curString);
        for (int i = 0; i < chars.length(); i++) {
            sb.append(chars.charAt(i));
            dfs(result, digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
