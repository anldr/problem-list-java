package acwing.Vol901to1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcWing905 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");
            ranges[i][0] = Integer.parseInt(info[0]);
            ranges[i][1] = Integer.parseInt(info[1]);
        }
        Arrays.sort(ranges, (range1, range2) -> {
            if (range1[0] != range2[0]) {
                return range1[0] - range2[0];
            }
            return range1[1] - range2[1];
        });
        int result = 1;
        int nowleft = ranges[0][0];
        int nowright = ranges[0][1];
        for (int i = 1; i < n; i++) {
            if (nowright < ranges[i][0]) {
                result++;
                nowleft = ranges[i][0];
                nowright = ranges[i][1];
            } else {
                nowleft = Math.max(nowleft, ranges[i][0]);
                nowright = Math.min(nowright, ranges[i][1]);
            }
        }
        System.out.println(result);
    }
}