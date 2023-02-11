package acwing.Vol4201to4300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing4261 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int arrLen = Integer.parseInt(buf.readLine());
        String inputStr = buf.readLine();

        int index = 0;
        long result = 0;
        int[] statistic = new int[arrLen + 7];

        statistic[++index] = 1;
        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == inputStr.charAt(i - 1)) {
                statistic[index]++;
            } else {
                statistic[++index] = 1;
            }
        }
        for (int i = 1; i <= index; i++) {
            if (statistic[i] == 1) {
                result += (long) statistic[i - 1] * statistic[i + 1];
            }
            if (statistic[i - 1] >= 2) {
                result += statistic[i - 1] - 1;
            }
            if (statistic[i + 1] >= 2) {
                result += statistic[i + 1] - 1;
            }
        }

        System.out.println(result);
    }
}
