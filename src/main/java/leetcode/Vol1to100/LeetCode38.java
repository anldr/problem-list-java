package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode38 {
    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);
        for (int i = 1; i < n; i++) {
            int num = 1;
            StringBuilder temp = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    num++;
                } else {
                    temp.append(num);
                    temp.append(result.charAt(j - 1));
                    num = 1;
                }
            }
            temp.append(num);
            temp.append(result.charAt(result.length() - 1));
            result = temp;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        log.info(countAndSay(1));
        log.info(countAndSay(2));
        log.info(countAndSay(3));
        log.info(countAndSay(4));
    }
}
