package AcWing;

import java.util.Scanner;

public class AcWing3798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int origin_n = n;
            int result = 1;
            while (n >= 10) {
                result = result * 10;
                n = n / 10;
            }
            result = result * (n + 1);
            System.out.println(result - origin_n);
        }
    }
}
