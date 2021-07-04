package AcWing;

import java.util.Scanner;

public class AcWing3617 {
    private static final int MAX_N = 4 + 7;
    private static int[] numA = new int[MAX_N];
    private static int[] numB = new int[MAX_N];
    public static void diffArray(int l, int r, int type) {
        if (type == 1) {
            numA[l]++;
            numA[r + 1]--;
        } else {
            numB[l]++;
            numB[r + 1]--;
        }
    }
    public static void sumArray(int n, int m) {
        for (int i = 1; i <= n; i++) {
            numA[i] += numA[i-1];
        }
        numA[n + 1] = 0;
        for (int i = 1; i <= m; i++) {
            numB[i] += numB[i-1];
        }
        numB[m + 1] = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int countNum = 0;
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            if (x == 1) {
                countNum++;
            } else {
                countNum = 0;
            }
            diffArray(1, countNum, 1);
        }
        countNum = 0;
        for (int i = 1; i <= m; i++) {
            int x = scanner.nextInt();
            if (x == 1) {
                countNum++;
            } else {
                countNum = 0;
            }
            diffArray(1, countNum, 2);
        }
        sumArray(n, m);
        long result = 0;
        for (int i = 1; i * i<= k; i++) {
            if (k % i == 0) {
                int tempA = i;
                int tempB = k / i;
                if (tempA <= n && tempB <= m) {
                    result = result + (numA[i] * numB[k / i]);
                }
                if (k / i != i) {
                    if (tempB <= n && tempA <= m) {
                        result = result + (numA[k / i] * numB[i]);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
