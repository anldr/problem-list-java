package leetcode.Vol1to100;

public class LeetCode67 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int maxIdx = Math.max(a.length(), b.length());
        for (int i = 1; i <= maxIdx; i++) {
            if (i <= a.length()) {
                sum = sum + a.charAt(a.length() - i) - '0';
            }
            if (i <= b.length()) {
                sum = sum + b.charAt(b.length() - i) - '0';
            }
            sb.append(sum % 2);
            sum = sum / 2;
        }
        if (sum != 0) {
            sb.append(sum);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addBinary("1010", "1011");
    }
}
