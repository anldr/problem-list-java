package z_others;

public class Test {
    public static int m;  //col
    public static int n; // row
    public static boolean[] visit;

    public static boolean isCir(int[][] mapp) {
        n = mapp.length;
        if (n == 0) {
            return true;
        }
        m = mapp[0].length;
        if (m == 0) {
            return true;
        }

        visit = new boolean[n];
        return dfs(mapp, 0);
    }
//       a   b    c
//    a  0   1    1
//
//    b  1   0    0
//
//    c  1   0    0

    public static boolean dfs(int[][] mapp, int idx) {
        if (idx >= n) {
            return true;
        }

        for (int i = idx + 1; i < m; i++) {
            if (mapp[idx][i] == 1) {
                if (!visit[idx]) {
                    visit[idx] = true;
                    return dfs(mapp, i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCir(new int[][]{{0, 1, 1}, {1, 0, 0}, {1, 0, 0}}));
    }
}
