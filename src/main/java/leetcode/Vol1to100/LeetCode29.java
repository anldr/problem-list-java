package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        boolean isMinus = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isMinus = true;
        }

        long result = 0;
        long absX = Math.abs((long) dividend);
        long absY = Math.abs((long) divisor);
        List<Long> multiNum = new LinkedList<>();
        for (long i = absY; i <= absX; i = i + i) {
            multiNum.add(i);
        }
        for (int i = multiNum.size() - 1; i >= 0; i--) {
            if (absX >= multiNum.get(i)) {
                result = result + (1L << i);
                absX = absX - multiNum.get(i);
            }
        }

        if (isMinus) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        log.info(String.valueOf(divide(2147483647, 2)));
        log.info(String.valueOf(divide(-2147483648, -1)));
        log.info(String.valueOf(divide(-1, 1)));
        log.info(String.valueOf(divide(10, 3)));
        log.info(String.valueOf(divide(7, -3)));
    }
}
