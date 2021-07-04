package AcWing;

import java.util.Scanner;

public class AcWing3731 {
    private static final int MAX_N = 103;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int[] a = new int[MAX_N];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            int flag = 1;
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i + flag] * flag + " ");
                flag = - flag;
            }
            System.out.println("");
        }
    }
}
