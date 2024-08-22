package z_others;

import java.util.HashMap;
import java.util.Map;

public class CaclDateUtils {
    private static final Map<Integer, Integer> MONTH_DAY = new HashMap<Integer, Integer>(){{
        put(1, 31);
        put(2, 28);
        put(3, 31);
        put(4, 30);
        put(5, 31);
        put(6, 30);
        put(7, 31);
        put(8, 31);
        put(9, 30);
        put(10, 31);
        put(11, 30);
        put(12, 31);
    }};

    public static void main(String[] args) {
        // expect 3
        System.out.println(dayOfYear(2016, 1, 3));
        // expect 32
        System.out.println(dayOfYear(2016, 2, 1));
        // expect 60
        System.out.println(dayOfYear(2016, 2, 29));

        // invalid
        System.out.println(dayOfYear(-1, 2, 1));
        System.out.println(dayOfYear(2016, -1, 1));
        System.out.println(dayOfYear(2016, 13, 1));
        System.out.println(dayOfYear(2016, 2, 30));
    }

    private static int dayOfYear(int year, int month, int day) {
        if (!isValidateYear(year)) {
            return -1;
        }

        int leapNum = isLeap(year) ? 1 : 0;
        if (!isValidateMonth(month) || !isValidateDay(day, (month == 2 ? leapNum : 0) + MONTH_DAY.get(month))) {
            return  -1;
        }

        int result = 0;
        for (int i = 1; i < month; i++) {
            result = result + MONTH_DAY.get(i) + (i == 2 ? leapNum : 0);
        }
        result = result + day;

        return result;
    }

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static boolean isValidateYear(int year) {
        return year >= 0;
    }

    private static boolean isValidateMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private static boolean isValidateDay(int day, int maxDay) {
        return day >= 1 && day <= maxDay;
    }
}
