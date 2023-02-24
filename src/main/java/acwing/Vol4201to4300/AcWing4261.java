package acwing.Vol4201to4300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * str:                G  H  G  H  G
 * str-index:          0  1  2  3  4
 *
 * statistic:       0  1  1  1  1  1
 * statistic-index: 0  1  2  3  4  5
 *
 * statistic数组：统计出连续每段的G(或H)的数量
 *
 * 计算答案，对于每个statistic[i]
 * 1、statistic[i] == 1，答案加上左右两边（乘法原理 statistic[i - 1] * statistic[i + 1]）
 * 2、statistic[i - 1] >= 2，对答案贡献加上 statistic[i - 1] - 1（即取statistic[i]中的一个，左边的取statistic[i - 1] - 1，这样的子串都满足条件）
 * 3、statistic[i + 1] >= 2，对答案贡献加上 statistic[i + 1] - 1（同第二步）
 */
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
            if (inputStr.charAt(i - 1) == inputStr.charAt(i)) {
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
