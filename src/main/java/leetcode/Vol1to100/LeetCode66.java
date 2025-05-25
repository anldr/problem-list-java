package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int arrLen = digits.length;
        for (int i = arrLen - 1; i >= 0; i++) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j <= arrLen - 1; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        int[] newArr = new int[arrLen + 1];
        newArr[0] = 1;
        return newArr;
    }
}
