package poj.Vol1400to1499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class POJ1416 {
    private static int maxLen = 0;

    private static int total = 0;

    private static int numSum = 0;

    private static int ansSum = 0;

    private static int targetNum = 0;

    private static String ansStr = "";

    private static String inputStr = "";

    private static List<Integer> ansList = new LinkedList<Integer>();

    private static List<Integer> ansIndexList = new LinkedList<Integer>();

//    private static TreeMap<String, Integer> ansMap = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] params = buf.readLine().split(" ");

            if (params[0].equals("0") && params[1].equals("0")) {
                return;
            }

            // init
            ansList.clear();
            ansIndexList.clear();
            maxLen = params[1].length();
            inputStr = params[1];
            targetNum = Integer.parseInt(params[0]);

            DFS (0, params[1]);

            Collections.sort(ansList);
            if (ansList.size() == 0) {
                System.out.println("error");
            } else if (ansList.get(ansList.size() - 1).equals(ansList.get(ansList.size() - 2))) {
                System.out.println("rejected");
            } else {
                System.out.println(ansList.get(ansList.size() - 1) + " " + ansStr);
            }
        }
    }

    public static void DFS(int dep, String numStr) {
        // return
        if (numStr.length() == 1 || (dep + numStr.length()) > maxLen) {
            if ((numSum + Integer.parseInt(numStr)) <= targetNum) {
//                ansMap
                ansStr = outputAns(inputStr);
            }
            return;
        }

        for (int i = 0; i < numStr.length(); i++) {
            // two strategies
            DFS(dep + 1, numStr.substring(i));

            if (total >= 2) {
                return ;
            }

            ansIndexList.add(maxLen - numStr.length() + i);
            numSum += Integer.parseInt(numStr.substring(0, i + 1));
            DFS(dep + 1, numStr.substring(i + 1));
            ansIndexList.remove(ansIndexList.size() - 1);
            numSum -= Integer.parseInt(numStr.substring(0, i + 1));

            if (total >= 2) {
                return ;
            }
        }
    }

    public static String outputAns(String str) {
        int idx = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ansIndexList.size(); i++) {
            if (i == (ansIndexList.size() - 1)) {
                ans.append(str, idx, ansIndexList.get(i) + 1).append(" ");
                idx = ansIndexList.get(i) + 1;
                ans.append(str, idx, str.length());
            } else {
                ans.append(str, idx, ansIndexList.get(i) + 1).append(" ");
                idx = ansIndexList.get(i) + 1;
            }
        }
        return ans.toString();
    }
}
