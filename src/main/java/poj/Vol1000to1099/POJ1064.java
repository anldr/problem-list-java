package poj.Vol1000to1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: xuchen
 * created: 2022/2/4 22:36
 * <p>
 * Description:
 */
public class POJ1064 {
    private static double[] cables = new double[10007];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String[] params = buf.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int k = Integer.parseInt(params[1]);

        for (int i = 0; i < n; i++) {
            cables[i] = Double.parseDouble(buf.readLine());
        }

        double left = -1.0;
        double right = 100007.0;
        while ((right - left) > 0.000001) {
            double mid = (right + left) / 2;
            if (check(n, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        //这题很奇怪，用左边界left就会WA
        if (right < 0.01) {
            System.out.println("0.00");
        }
        else {
            System.out.printf("%.2f%n", (int)(right * 100) / 100.0);
        }
    }

    public static boolean check(int n, int k, double mid) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + (int)(cables[i] / mid);
        }

        return result >= k;
    }
}
