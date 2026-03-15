package leetcode.Vol101to200;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode151 {
    public String reverseWords(String s) {
        String temp = s.trim();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ' ' && result.charAt(result.length() - 1) != ' ') {
                result.append(temp.charAt(i));
            } else if (temp.charAt(i) != ' ') {
                result.append(temp.charAt(i));
            }
        }

        List<String> list = Stream.of(result.toString().split("\\s")).collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
