package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode6 {
    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();

        if (numRows == 1) {
            return s;
        }
        int constNum = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + constNum) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i, k = constNum - i; j < s.length() || k < s.length(); j = j + constNum, k = k + constNum) {
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                    }
                    if (k < s.length()) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        log.info(convert("A", 1));
        log.info(convert("PAYPALISHIRING", 3));
        log.info(convert("PAYPALISHIRING", 4));
    }
}
