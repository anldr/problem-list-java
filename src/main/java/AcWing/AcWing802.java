package AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcWing802 {
    public static void main (String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        List<Integer> alls = new LinkedList<>();
        List<Pair> addOp = new LinkedList<>();
        List<Pair> queryOp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            params = buf.readLine().split(" ");
            int x = Integer.parseInt(params[0]);
            int c = Integer.parseInt(params[1]);
            alls.add(x);
            addOp.add(new Pair(x, c));
        }

        for (int i = 0; i < m; i++) {
            params = buf.readLine().split(" ");
            int l = Integer.parseInt(params[0]);
            int r = Integer.parseInt(params[1]);
            alls.add(l);
            alls.add(r);
            queryOp.add(new Pair(l, r));
        }

        alls = discrete(alls);
//        System.out.println(alls);

        int[] sum = new int[alls.size() + 5];
        for (Pair op : addOp) {
            sum[getId(alls, op.x) + 1] += op.y;
        }

        for (int i = 1; i <= alls.size(); i++) {
            sum[i] += sum[i - 1];
        }

//        System.out.println(Arrays.toString(sum));

        for (Pair query : queryOp) {
            System.out.println(sum[getId(alls, query.y) + 1] - sum[getId(alls, query.x)]);

//            System.out.println("l = " + query.x + "  r = " + query.y + "--->" + getId(alls, query.x) + ",   " + getId(alls, query.y));
        }
    }

    private static List<Integer> discrete(List<Integer> alls) {
        Collections.sort(alls);
        // 去重
        return unique(alls);
    }

    private static int getId(List<Integer> alls, int x) {
        return binSearch(alls, x);
    }

    private static int binSearch(List<Integer> alls, int x) {
        int l = 0;
        int r = alls.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (alls.get(mid) >= x) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static List<Integer> unique(List<Integer> alls) {
        int index = 1;
        for (int i = 1; i < alls.size(); i++) {
            if (!alls.get(i).equals(alls.get(i - 1))) {
                alls.set(index, alls.get(i));
                index++;
            }
        }
        alls = alls.subList(0, index);
        return alls;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}