package poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class POJ3414 {
    private static final int MAX_STEP = 107;

    private static final String[] OPERATIONS = {
            "FILL(1)", "FILL(2)", "DROP(1)", "DROP(2)", "POUR(1,2)", "POUR(2,1)"
    };

    private static boolean[][] visit = new boolean[MAX_STEP][MAX_STEP];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");

        int potACapcity = Integer.parseInt(params[0]);
        int potBCapcity = Integer.parseInt(params[1]);
        int aim = Integer.parseInt(params[2]);

        Bfs(potACapcity, potBCapcity, aim);
    }

    private static void Bfs(int potACapcity, int potBCapcity, int aim) {
        Deque<Node> que = new LinkedList<Node>();

        visit[0][0] = true;
        String[] path = new String[MAX_STEP];
        que.addLast(new Node(0, 0, 0, path, 0));

        while (que.size() > 0) {
            Node now = que.pollFirst();

            if (now.potA == aim || now.potB == aim) {
                // output answer
                System.out.println(now.step);
                for (int i = 0; i < now.pathLength; i++) {
                    System.out.println(now.path[i]);
                }

                return ;
            }

            // 处理几种情况
            fill2PotA(now, potACapcity, que);
            fill2PotB(now, potBCapcity, que);
            dropPotA(now, que);
            dropPotB(now, que);
            pourPotA2B(now, potBCapcity, que);
            pourPotB2A(now, potACapcity, que);
        }

        System.out.println("impossible");
    }

    private static void fill2PotA(Node now, int potACapcity, Deque<Node> que) {
        if (now.potA == potACapcity) {
            return;
        }

        Node newNode = new Node();

        newNode.potA = potACapcity;
        newNode.potB = now.potB;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[0];
        newNode.step = now.step + 1;

        if (!visit[potACapcity][now.potB]) {
            que.addLast(newNode);
            visit[potACapcity][now.potB] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + " operation " + newNode.path[newNode.pathLength - 1]);
        }
    }

    private static void fill2PotB(Node now, int potBCapcity, Deque<Node> que) {
        if (now.potB == potBCapcity) {
            return;
        }

        Node newNode = new Node();

        newNode.potA = now.potA;
        newNode.potB = potBCapcity;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[1];
        newNode.step = now.step + 1;

        if (!visit[now.potA][potBCapcity]){
            que.addLast(newNode);
            visit[now.potA][potBCapcity] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + "operation " + newNode.path[newNode.pathLength - 1]);
        }

    }

    private static void dropPotA(Node now, Deque<Node> que){
        if (now.potA == 0) {
            return;
        }

        Node newNode = new Node();

        newNode.potA = 0;
        newNode.potB = now.potB;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[2];
        newNode.step = now.step + 1;

        if (!visit[0][now.potB]) {
            que.addLast(newNode);
            visit[0][now.potB] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + "operation " + newNode.path[newNode.pathLength - 1]);
        }

    }

    private static void dropPotB(Node now, Deque<Node> que){
        if (now.potB == 0) {
            return;
        }

        Node newNode = new Node();

        newNode.potA = now.potA;
        newNode.potB = 0;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[3];
        newNode.step = now.step + 1;

        if (!visit[now.potA][0]) {
            que.addLast(newNode);
            visit[now.potA][0] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + "operation " + newNode.path[newNode.pathLength - 1]);
        }

    }

    private static void pourPotA2B(Node now, int potBCapcity, Deque<Node> que){
        if (now.potA == 0 || potBCapcity == now.potB) {
            return;
        }

        int potAValue = Math.max(now.potA - (potBCapcity - now.potB), 0);
        int potBValue = Math.min(potBCapcity, now.potA + now.potB);

        Node newNode = new Node();

        newNode.potA = potAValue;
        newNode.potB = potBValue;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[4];
        newNode.step = now.step + 1;

        if (!visit[potAValue][potBValue]) {
            que.addLast(newNode);
            visit[potAValue][potBValue] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + "operation " + newNode.path[newNode.pathLength - 1]);
        }

    }

    private static void pourPotB2A(Node now, int potACapcity, Deque<Node> que){
        if (now.potB == 0 || now.potA == potACapcity) {
            return;
        }

        int potAValue = Math.min(potACapcity, now.potA + now.potB);
        int potBValue = Math.max(now.potB - (potACapcity - now.potA), 0);

        Node newNode = new Node();

        newNode.potA = potAValue;
        newNode.potB = potBValue;
        for (int i = 0; i < now.pathLength; i++) {
            newNode.path[i] = now.path[i];
        }
        newNode.pathLength = now.pathLength + 1;
        newNode.path[now.pathLength] = OPERATIONS[5];
        newNode.step = now.step + 1;

        if (!visit[potAValue][potBValue]) {
            que.addLast(newNode);
            visit[potAValue][potBValue] = true;

//            System.out.println(newNode.potA + " " + newNode.potB + "operation " + newNode.path[newNode.pathLength - 1]);
        }

    }

    static class Node{
        public int potA;
        public int potB;
        public int pathLength;

        public int step;

        String[] path = new String[MAX_STEP];

        Node() {}

        Node(int potA, int potB, int pathLength, String[] path, int step) {
            this.potA = potA;
            this.potB = potB;
            this.path = path;
            this.step = step;
            this.pathLength = pathLength;
        }
    }
}
