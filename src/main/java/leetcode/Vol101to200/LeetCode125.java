package leetcode.Vol101to200;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        int ptr1 = 0;
        int ptr2 = s.length() - 1;

        while (true) {
            if (ptr1 >= ptr2) {
                return true;
            }
            if (!isAlpha(s.charAt(ptr1))) {
                ptr1++;
                continue;
            }
            if (!isAlpha(s.charAt(ptr2))) {
                ptr2--;
                continue;
            }
            if (getLowChar(s.charAt(ptr1)) != getLowChar(s.charAt(ptr2))) {
                return false;
            }

            ptr1++;
            ptr2--;
        }
    }

    private char getLowChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)((int)c - (int)'A' + (int)'a');
        }
        return c;
    }

    private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
