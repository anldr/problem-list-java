package leetcode.Vol1701to1800;

/**
 * author: xuchen
 * created: 2022/2/1 14:14
 * <p>
 * Description:
 * 当一个字符串 s包含的每一种字母的大写和小写形式 同时出现在 s中，就称这个字符串s是 美好 字符串。比方说，"abABB"是美好字符串，因为'A' 和'a'同时出现了，且'B' 和'b'也同时出现了。
 * 然而，"abA"不是美好字符串因为'b'出现了，而'B'没有出现。
 *
 * 给你一个字符串s，请你返回s最长的美好子字符串。如果有多个答案，请你返回最早出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 *
 * 1 <= s.length <= 100
 *
 * s 只包含大写和小写英文字母。
 *
 *
 * 二进制优化这一招不错
 */
public class LeetCode1763 {
    class Solution {
        public String longestNiceSubstring(String s) {
            String reslut = "";
            int len = s.length();

            for (int i = 0; i < len; i++) {
                int a = 0;
                int b = 0;
                for (int j = i; j < len; j++) {
                    char c = s.charAt(j);
                    if (c >= 'A' && c <= 'Z') {
                        b = b | (1 << (c - 'A'));
                    } else {
                        a = a | (1 << (c - 'a'));
                    }
                    if (a == b && (j - i + 1) > reslut.length()) {
                        reslut = s.substring(i, j + 1);
                    }
                }
            }

            return reslut;
        }
    }
}
