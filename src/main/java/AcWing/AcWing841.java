package AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing841 {
    private static final int P = 131;

    private static final int N = 100007;

    private static long[] hashValue = new long[N];

    private static long[] pPower = new long[N];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        String input = buf.readLine();

        pPower[0] = 1;
        for (int i = 1; i <= n; i++) {
            hashValue[i] = hashValue[i - 1] * P + input.charAt(i - 1);
            pPower[i] = pPower[i - 1] * P;
        }

        for (int i = 0; i < m; i++) {
            params = buf.readLine().split(" ");
            int l = Integer.parseInt(params[0]);
            int r = Integer.parseInt(params[1]);
            int q = Integer.parseInt(params[2]);
            int p = Integer.parseInt(params[3]);

            if (getHashValue(l, r) == (getHashValue(q, p))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static long getHashValue(int l, int r) {
        return hashValue[r] - hashValue[l - 1] * pPower[r - l + 1];
    }
}
