package leetcode.Vol1to100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode12 {
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

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            for (Map.Entry<String, Integer> entry : ROMA_INT.entrySet()) {
                if (num >= entry.getValue()) {
                    num = num - entry.getValue();
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(3123));
    }
}
