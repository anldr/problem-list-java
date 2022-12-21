package acwing.Vol601to700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing659 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");

        double efs = 0.0000000f;
        double num = Double.parseDouble(params[0]);

        if (num - 100 > efs || 0 - num > efs) {
            System.out.println("Fora de intervalo");
        } else if (num - 0 >= efs && 25 - num >= efs) {
            System.out.println("Intervalo [0,25]");
        } else if (num - 25 > efs && 50 - num >= efs) {
            System.out.println("Intervalo (25,50]");
        } else if (num - 50 > efs && 75 - num >= efs) {
            System.out.println("Intervalo (50,75]");
        } else if (num - 75 > efs && 100 - num >= efs) {
            System.out.println("Intervalo (75,100]");
        }
    }
}
