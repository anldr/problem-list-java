package poj.Vol3100to3199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: xuchen
 * created: 2022/2/3 22:50
 * <p>
 * Description:
 */
public class POJ3134 {
    private static int n = -1;

    private static int pos = 0;

    private static int deepMax = 1;

    private static int[] nums = new int[1007];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            n = Integer.parseInt(buf.readLine());

            if (n == 0) {
                break;
            }

            deepMax = 0;
            while (true) {
                pos = 0;
                nums[0] = 1;
                if (idAStar(0)) {
                    System.out.println(deepMax);
                    break;
                }
                deepMax++;
            }
        }
    }

    public static boolean idAStar(int nowDep) {
        if (nowDep > deepMax) {
            return false;
        }

        if ((nums[pos] << (deepMax - nowDep)) < n) {
            return false;
        }

        if (nums[pos] == n) {
            return true;
        }

        pos++;
        for (int i = 0; i < pos; i++) {
            nums[pos] = nums[pos - 1] + nums[i];

            if (idAStar(nowDep + 1)) {
                return true;
            }

            nums[pos] = Math.abs(nums[pos - 1] - nums[i]);

            if (idAStar(nowDep + 1)) {
                return true;
            }
        }
        pos--;

        return false;
    }
}
