package AcWing;

import java.util.Scanner;

public class AcWing3763 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int sum = 0;
            int count = 0;
            int minNum = 1000;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = scanner.nextInt();
                    sum += Math.abs(x);
                    minNum = Math.min(minNum, Math.abs(x));
                    if (x < 0) {
                        count++;
                    }
                }
            }
            if ((count & 1) == 0) {
                System.out.println(sum);
            }
            else {
                System.out.println(sum - 2 * minNum);
            }
        }
    }
}
