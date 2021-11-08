package AcWing;

import java.util.Scanner;

public class AcWing3792 {
    private static final int MAX_N = 1007;

    private static boolean[] isPrime = new boolean[MAX_N];

    private static int[] primes = new int[MAX_N];

    private static int cnt = 0;

    // 线性筛质数
    public static void get_primes(int n) {
        for (int i = 2; i <= n; i ++ ) {
            if (!isPrime[i]) primes[cnt ++ ] = i;
            for (int j = 0; primes[j] <= n / i; j ++ ) {
                isPrime[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }

    public static void main(String[] args) {
        get_primes(1001);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int total = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    continue;
                }
                for (int j = 1; j < cnt; j++) {
                    if (primes[j - 1] + primes[j] + 1 == i) {
                        total++;
                        break;
                    }
                }
            }
            if (total >= k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            T--;
        }
    }
}