package acwing.Vol601to700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing665 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");

        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        if (n % m == 0 || m % n == 0) {
            System.out.println("Sao Multiplos");
        } else {
            System.out.println("Nao sao Multiplos");
        }
    }
}
