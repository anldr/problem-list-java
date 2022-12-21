package leetcode.Vol1to100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode13 {
    private static final Map<String, Integer> ROMA_INT = new LinkedHashMap<String, Integer>(){{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public static int romanToInt(String s) {
        int result  = 0;
        for (int i = 0; i < s.length(); ) {
            // 先取两个字符
            String temp = s.substring(i, Math.min(s.length(), i + 2));
            if (ROMA_INT.containsKey(temp)) {
                result = result + ROMA_INT.get(temp);
                i = i + 2;
                continue;
            }
            temp = s.substring(i, Math.min(s.length(), i + 1));
            result = result + ROMA_INT.get(temp);
            i = i + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
