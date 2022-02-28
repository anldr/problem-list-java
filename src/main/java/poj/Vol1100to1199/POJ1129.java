package poj.Vol1100to1199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * author: xuchen
 * created: 2022/1/16 23:31
 *
 * Description:
 * 给平面上任意两点之间的连线无交叉的图染色，最少需要几种颜色
 * 根据四色定理，不会超过四种颜色
 */
public class POJ1129 {
    private static final int MAX_N = 26;

    private static int n = 0;

    private static int result = 0;

    private static int[] nodeColor = new int[MAX_N];

    private static String[] input = new String[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            n = Integer.parseInt(buf.readLine());

            if (n == 0) {
                return ;
            }

            // init and input
            result = 0;
            for (int i = 0; i < MAX_N; i++) {
                nodeColor[i] = -1;
//                color[i] = false;
            }

            for (int i = 0; i < n; i++) {
                String[] params = buf.readLine().split(":");
                if (params.length == 1) {
                    input[i] = "";
                } else {
                    input[i] = params[1];
                }
            }

            DFS(0);

            if (result > 1) {
                System.out.println(result + " channels needed.");
            } else {
                System.out.println(result + " channel needed.");
            }
        }
    }

    public static boolean DFS(int dep) {
        // return
        if (dep >= n) {
            HashSet<Integer> colorSet = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                colorSet.add(nodeColor[i]);
            }
            result = colorSet.size();
            return true;
        }

        // step 1. find color
        for (int i = 0; i < MAX_N; i++) {
            if (!isConflict(dep, i)) {
                nodeColor[dep] = i;
                if (DFS(dep + 1)) {
                    return true;
                }
                nodeColor[dep] = -1;
            }
        }

        return false;
    }

    public static boolean isConflict(int dep, int x) {
        for (int i = 0; i < input[dep].length(); i++) {
            if (nodeColor[input[dep].charAt(i) - 'A'] == x) {
                return true;
            }
        }

        return false;
    }
}
