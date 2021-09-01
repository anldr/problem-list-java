package AcWing;

import java.util.Scanner;

public class AcWing3815 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            long n = scanner.nextLong();
            long x = 2;
            long result = n;
            while (n != 1 && (x * x) <= n) {
                while (result % (x * x) == 0) {
                    result = result / x;
                }
                x++;
            }
            System.out.println(result);
        }
    }
}