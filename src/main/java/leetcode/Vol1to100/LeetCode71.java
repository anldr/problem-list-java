package leetcode.Vol1to100;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode71 {
    public String simplifyPath(String path) {
        Deque<String> que = new ArrayDeque<>();

        int len = path.length();
        for (int i = 0; i < len ; i++) {
            if (path.charAt(i) == '.') {
                StringBuilder dots = new StringBuilder();
                for (; i < len && path.charAt(i) != '/'; i++) {
                    dots.append(path.charAt(i));
                }
                if (dots.toString().equals("..")) {
                    que.pollLast();
                } else if (!dots.toString().equals(".")) {
                    que.addLast(dots.toString());
                }
            } else if (path.charAt(i) != '/') {
                StringBuilder str = new StringBuilder();
                for (; i < len && path.charAt(i) != '/'; i++) {
                    str.append(path.charAt(i));
                }
                que.addLast(str.toString());
                i--;
            }
        }

        StringBuilder result = new StringBuilder();
        while(!que.isEmpty()) {
            result.append("/").append(que.pollFirst());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
