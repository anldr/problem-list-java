package hdu.Vol4400to4499;

import java.io.BufferedInputStream;
import java.util.*;

// TLE
public class HDU4460 {
    private static final int MAX_N = 1007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt();
        while (n != 0) {
            int num = 0;
            int[][] relation = new int[MAX_N][MAX_N];
            Map<String, Integer> name2Num = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String str = sc.next();
                name2Num.put(str, num);
                num++;
            }

            int edgeNum = sc.nextInt();
            for (int i = 0; i < edgeNum; i++) {
                String strA = sc.next();
                String strB = sc.next();

                relation[name2Num.get(strA)][name2Num.get(strB)] = 1;
                relation[name2Num.get(strB)][name2Num.get(strA)] = 1;
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(relation[i][j] + " ");
//                }
//                System.out.println();
//            }

            int ans = -1;
            if (edgeNum < (n - 1)) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < n; i++) {
                    int reslut = Bfs(n, i, relation);
                    if (reslut == -1) {
                        ans = -1;
                        break;
                    }
                    ans = Math.max(ans, reslut);
                }

                if (ans >= 7) {
                    System.out.println(-1);
                } else {
                    System.out.println(ans);
                }
            }

            n = sc.nextInt();
        }
    }

    private static int Bfs(int n, int start, int[][] relation) {
        int[] visit = new int[MAX_N];
        Deque<Integer> que = new LinkedList<>();

        // init
        for (int i = 0; i < n; i++) {
            visit[i] = -1;
        }

        que.addLast(start);
        visit[start] = 0;

        int result = -1;
        while(que.size() > 0) {
            int now = que.pollFirst();

            for (int i = 0; i < n; i++) {
                if (i != now && relation[now][i] == 1 && visit[i] == -1) {
                    que.addLast(i);
                    visit[i] = visit[now] + 1;
                }
            }

            result = Math.max(result, visit[now]);
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == -1) {
                result = -1;
                break;
            }
        }

        return result;
    }
}
