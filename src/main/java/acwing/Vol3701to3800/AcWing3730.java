package acwing.Vol3701to3800;

import java.util.Scanner;

public class AcWing3730 {
    private static final int MAX_N = 103;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int[] seqA = new int[MAX_N];
            int[] seqB = new int[MAX_N];
            int[] seqC = new int[MAX_N];
            int[] result = new int[MAX_N];
            int preNum = -1;
            for (int i = 1; i <= n; i++) {
                seqA[i] = scanner.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                seqB[i] = scanner.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                seqC[i] = scanner.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                if (seqA[i] != preNum) {
                    result[i] = seqA[i];
                    preNum = seqA[i];
                } else if (seqB[i] != preNum) {
                    result[i] = seqB[i];
                    preNum = seqB[i];
                } else {
                    result[i] = seqC[i];
                    preNum = seqC[i];
                }
                if (i == n) {
                    preNum = result[i-1];
                    if (seqA[i] != preNum && seqA[i] != result[1]) {
                        result[i] = seqA[i];
                    } else if (seqB[i] != preNum && seqB[i] != result[1]) {
                        result[i] = seqB[i];
                    } else {
                        result[i] = seqC[i];
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
