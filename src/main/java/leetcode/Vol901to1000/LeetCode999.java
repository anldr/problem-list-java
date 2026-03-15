package leetcode.Vol901to1000;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeetCode999 {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, Integer> boardMap = new HashMap<>();
        Map<Integer, Integer> stepMap = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int total = n * n;
        for (int i = 1; i <= total; i++) {
            int[] rc = id2Rc(i , n);
            boardMap.put(i, board[rc[0]][rc[1]]);
        }
        queue.add(1);
        stepMap.put(1, 0);
        while(!queue.isEmpty()) {
            int i = queue.poll();
            for (int k = 1; k <= 6; k++) {
                int boardNum = boardMap.get(Math.min(i + k, n * n));
                int stepNum = boardNum == -1 ? Math.min(i + k, n * n) : boardNum;
                int original = stepMap.get(i);
                int exist = stepMap.getOrDefault(stepNum, -1);
                if (exist == -1) {
                    stepMap.put(stepNum, original + 1);
                    queue.add(stepNum);
                }
            }
        }

        return stepMap.getOrDefault( n * n, -1);
    }

    private static int[] id2Rc(int i, int n) {
        int r = (i - 1) / n;
        int c = (i - 1) % n;
        if (r % 2 == 1) {
            c = n - c - 1;
        }

        return new int[]{n - r - 1, c};
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}};
        int result = snakesAndLadders(board);
        System.out.println(result);
    }
}
