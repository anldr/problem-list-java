package projecteuler.Vol1to50;

import java.util.*;

public class Problem35 {
    private static int MAX_N = 1000007;

    private static boolean[] visited = new boolean[MAX_N];

    private static int[] prime = new int[MAX_N];

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 2; i < MAX_N; i++) {
            if (!visited[i]) {
                prime[cnt++] = i;
            }
            for (int k = 0; k < cnt && i * prime[k] < MAX_N; k++) {
                visited[i * prime[k]] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < cnt; i++) {
            if (checkFunc(prime[i])) {
                result++;
            }
        }

        System.out.println("answer:" + result);
    }

    private static boolean checkFunc(int tempNum) {
        List<Integer> nums = getRotationNum(tempNum);

        for (int num : nums) {
            if (visited[num]) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> getRotationNum(int num) {
        List<Integer> nums = new LinkedList<>();
        int cnt = 0;
        int divisor = 1;
        while (divisor < num) {
            cnt++;
            divisor *= 10;
        }
        divisor /= 10;

        for (int i = 0; i < cnt; i++) {
            nums.add(num);
            num = (num % divisor) * 10 + num / divisor;
        }

        return nums;
    }
}
