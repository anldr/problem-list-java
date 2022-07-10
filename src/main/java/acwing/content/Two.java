package acwing.content;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");

        long n = Long.parseLong(params[0]);

        long result = 0;
        while (n > 0) {
            long minPrimeFactor = findFactor(n);
            n = n - minPrimeFactor;
            result++;
            if (n % 2 == 0) {
                result = result + n / 2;
                break;
            }
        }

        System.out.print(result);
    }

    public static long findFactor(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (isPrime(i) && n % i == 0) {
                return i;
            }
        }

        return n;
    }

    public static boolean isPrime(long x) {
        if (x == 2) return true;
        if (x % 2 == 0) {
            return false;
        }

        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
