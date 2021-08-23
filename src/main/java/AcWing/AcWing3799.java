package AcWing;

import java.util.Scanner;

public class AcWing3799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int k = scanner.nextInt();
            int a = scanner.nextInt();
            int sub = 1;
            while (a >= 0 && k >= 0) {
                if ((sub & 1) == 1) {
                    k -= sub;
                } else {
                    a -=sub;
                }
                sub++;
            }
            if (k < 0) {
                System.out.println("Vladik");
            } else {
                System.out.println("Valera");
            }
        }
    }
}

