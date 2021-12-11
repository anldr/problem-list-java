package acwing.Vol3801to3900;

import java.util.Scanner;

public class AcWing3824 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int pre = -3;
            int result = 0;
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                if (x == 1) {
                    result++;
                    if ((i - pre) == 2) {
                        result++;
                    }
                    pre = i;
                }
            }

            System.out.println(result);
        }
    }
}
