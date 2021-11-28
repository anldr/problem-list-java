package acwing;

import java.util.Scanner;

public class AcWing3817 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int na = scanner.nextInt();
        int nb = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int numa = -1;
        int numb = -1;
        for (int i = 0; i < na; i++) {
            int x = scanner.nextInt();
            if (i == (k - 1)) {
                numa = x;
            }
        }
        for (int i = 0; i < nb; i++) {
            int x = scanner.nextInt();
            if (i == (nb - m)) {
                numb = x;
            }
        }
        if (numa < numb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
