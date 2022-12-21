package acwing.Vol601to700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing660 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");

        int num = Integer.parseInt(params[0]);
        int tot = Integer.parseInt(params[1]);

        if (num == 1) {
            System.out.println("Total: R$ " + String.format("%.2f", 4.00f * tot));
        } else if (num == 2) {
            System.out.println("Total: R$ " + String.format("%.2f", 4.50f * tot));
        } else if (num == 3) {
            System.out.println("Total: R$ " + String.format("%.2f", 5.00f * tot));
        } else if (num == 4) {
            System.out.println("Total: R$ " + String.format("%.2f", 2.00f * tot));
        } else if (num == 5) {
            System.out.println("Total: R$ " + String.format("%.2f", 1.50f * tot));
        }
    }
}
