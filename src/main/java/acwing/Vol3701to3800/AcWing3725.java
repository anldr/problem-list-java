package acwing.Vol3701to3800;

import java.util.Scanner;

public class AcWing3725 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (r <= (2 * l - 1)) {
                System.out.println("YES");
            } else  {
                System.out.println("NO");
            }
        }
    }
}
