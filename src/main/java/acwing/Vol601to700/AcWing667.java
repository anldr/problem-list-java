package acwing.Vol601to700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing667 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");

        int st = Integer.parseInt(params[0]);
        int ed = Integer.parseInt(params[1]);

        if (st == ed) {
            System.out.println("O JOGO DUROU 24 HORA(S)");
        } else if (ed > st) {
            System.out.println("O JOGO DUROU " + (ed - st) + " HORA(S)");
        } else {
            System.out.println("O JOGO DUROU " + ( 24 + ed - st) + " HORA(S)");
        }
    }
}
