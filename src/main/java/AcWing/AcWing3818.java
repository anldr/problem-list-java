package AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcWing3818 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");
            ranges[i][0] = Integer.parseInt(info[0]);
            ranges[i][1] = Integer.parseInt(info[1]);
        }
        Arrays.sort(ranges, Comparator.comparingInt(range -> range[1]));

        int right = ranges[0][1];
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (ranges[i][0] > right) {
                result++;
                right = ranges[i][1];
            }
        }
        System.out.println(result);
    }
}
