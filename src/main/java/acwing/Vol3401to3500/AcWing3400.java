package acwing.Vol3401to3500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class AcWing3400 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] arrNum = buf.readLine().split(" ");
        int n, k;
        n = Integer.parseInt(arrNum[0]);
        k = Integer.parseInt(arrNum[1]);

        Queue<NumClass> que = new LinkedList<>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            que.add(new NumClass(i, i == k ? 1 : 0));
        }

        int res = 0;
        while (que.size() > 0) {
            NumClass temp = que.remove();
            res = res + temp.getNumOfK();
            for (int i = 0; i <= 9; i++) {
                int tempNum = temp.getVal() * 10 + i;
                if (tempNum > n) {
                    break;
                }
                que.add(new NumClass(tempNum, temp.getNumOfK() + (i == k ? 1 : 0)));
            }
        }

        System.out.println(res);
    }

    public static class NumClass {
        int val;
        int numOfK;

        public NumClass(int val, int k) {
            this.val = val;
            this.numOfK = k;
        }

        public int getVal() {
            return val;
        }

        public int getNumOfK() {
            return numOfK;
        }
    }
}
