package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode38 {
    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();

        StringBuilder temp = new StringBuilder();
        temp.append(1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) == temp.charAt(j - 1)) {

                }
            }
            temp = result;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        log.info(countAndSay(1));
    }
}
