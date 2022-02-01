package hdu.Vol1100to1199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: xuchen
 * created: 2022/1/19 0:27
 * <p>
 * Description:
 *
 * IDDFS-迭代加深搜索
 */
public class AcWing1120 {
    private static final int MAX_DEEP = 100;

    private static final int MAX_DIGTAL = 1000007;

    private static long a = 0;

    private static long b = 0;

    private static int nowDeep = 0;

    private static long[] ans = new long[MAX_DEEP + 3];

    private static long[] nums = new long[MAX_DEEP + 3];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");
        a = Long.parseLong(params[0]);
        b = Long.parseLong(params[1]);

        if (a == 1) {
            System.out.println(b);
            return ;
        }

        for (int i = 2; i <= MAX_DEEP; i++) {
            nowDeep = i;
            if (dfs(1, a, b, b / a)) {
                break;
            }
        }

        for (int i = 1; i <= nowDeep; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
    }

    public static boolean dfs(int dep, long x, long y, long last) {
        if (dep >= nowDeep) {
            // check
            if (x == 1) {
                nums[dep] = y;
                if (ans[dep] == 0 || ans[dep] > y) {
                    System.arraycopy(nums, 1, ans, 1, dep);
                    return true;
                }
            }

            return false;
        }
        boolean flag = false;
        for (long i = Math.max(last, y / x) + 1; i < ((y / x) * (nowDeep - dep + 1)); i++) {
            long tempA = x * i - y;
            long tempB = y * i;
            long g = gcd(Math.abs(tempA), tempB);
            tempA = tempA / g;
            tempB = tempB / g;
            nums[dep] = i;
            if (dfs(dep + 1, tempA, tempB, i)) {
                flag = true;
            }
        }

        return flag;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
