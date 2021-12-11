package acwing.Vol3701to3800;

import java.util.Scanner;

public class AcWing3800 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            boolean numB = isEven(b);
            int result = 0;
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                if (i != k - 1) {
                    result = result + ((numB || isEven(x)) ? 0 : 1);
                } else {
                    result = result + (isEven(x) ? 0 : 1);
                }
            }
            if ((result & 1) == 1) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
        }
    }

    private static boolean isEven(int x) {
        return (x & 1) == 0;
    }
}
