package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int strLength = 0;
        int realLength = 0;
        List<String> result = new ArrayList<>();
        List<String> subStrings = new ArrayList<>();
        for (String word : words) {
            int tempLength = strLength + word.length();
            if (tempLength >= maxWidth) {
                if (tempLength == maxWidth) {
                    subStrings.add(word);
                    realLength = realLength + word.length();
                }
                String str = buildString(subStrings, maxWidth - realLength);
                result.add(str);
                strLength = 0;
                realLength = 0;
                subStrings = new ArrayList<>();

                if (tempLength > maxWidth) {
                    subStrings.add(word);
                    strLength = strLength + word.length() + 1;
                    realLength = realLength + word.length();
                }
            } else {
                subStrings.add(word);
                strLength = strLength + word.length() + 1;
                realLength = realLength + word.length();
            }
        }

        if (!subStrings.isEmpty()) {
            String str = buildStringLeft(subStrings, maxWidth - realLength);
            result.add(str);
        }

        return result;
    }

    private static String buildString(List<String> strList, int blankLength) {
        if (strList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(strList.get(0));
            for (int i = 1; i <= blankLength; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        int emptyNum = strList.size() - 1;
        int avgBlank = blankLength / emptyNum;
        int modBlank = blankLength % emptyNum;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < emptyNum; i++) {
            sb.append(strList.get(i));
            for (int k = 1; k <= avgBlank; k++) {
                sb.append(" ");
            }
            if (modBlank > 0) {
                sb.append(" ");
                modBlank--;
            }
        }

        sb.append(strList.get(emptyNum));

        return sb.toString();
    }

    private static String buildStringLeft(List<String> strList, int blankLength) {
        if (strList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(strList.get(0));
            for (int i = 1; i <= blankLength; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            sb.append(strList.get(i)).append(' ');
            blankLength--;
        }

        for (int k = 1; k <= blankLength; k++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int maxWidth = 20;
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        fullJustify(words, maxWidth);
    }
}
