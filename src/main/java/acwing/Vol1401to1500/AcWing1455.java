package acwing.Vol1401to1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String param = buf.readLine();
        int t = Integer.parseInt(param);

        for (int i = 0; i < t; i++) {
            String[] params = buf.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[] array = new int[m];
            for (int j = 0; j < m; j++) {
                array[j] = Integer.parseInt(params[j + 2]);
            }

            int result = 0;
            for (int k = 2; k <= n; k++) {
                result = (result + array[(n - k) % m]) % k;
            }

            System.out.println(result);
        }
    }
}
