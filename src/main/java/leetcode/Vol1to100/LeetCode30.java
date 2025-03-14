package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wordNum = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> wordMap = new HashMap<>();
        for (int k = 0; k < words.length; k++) {
            int count = wordMap.getOrDefault(words[k], 0);
            wordMap.put(words[k], count + 1);
        }

        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> curWordMap = new HashMap<>();
            for (int j = i; j + wordLen <= sLen; j = j + wordLen) {
                String subStr = s.substring(j, j + wordLen);
                if (j >= i + (wordNum * wordLen)) {
                    int ptr = j - (wordNum * wordLen);
                    String removeStr = s.substring(ptr, ptr + wordLen);
                    curWordMap.put(removeStr, curWordMap.getOrDefault(removeStr, 0) - 1);
                    if (curWordMap.get(removeStr) <= 0) {
                        curWordMap.remove(removeStr);
                    }
                }
                int count = curWordMap.getOrDefault(subStr, 0) + 1;
                curWordMap.put(subStr, count);
                if (wordMap.equals(curWordMap)) {
                    result.add(j - (wordNum - 1) * wordLen);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = new String[]{"c","b","a","c","a","a","a","b","c"};

        findSubstring(s, words);
    }
}
