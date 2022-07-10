package acwing.content;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");

        int n = Integer.parseInt(params[0]);

        params = buf.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(params[i]);
        }

        int sumArr = 0;
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            sumArr = sumArr + arr[i];
            preSum = Math.min(preSum, sumArr);
        }

        System.out.println(sumArr - preSum);
    }
}
