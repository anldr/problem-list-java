package poj.Vol1400to1499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class POJ1416 {
    private static int maxLen = 0;

    private static int ansSum = 0;

    private static int targetNum = 0;

    private static String ansStr = "";

    private static String inputStr = "";

    private static List<String> ansList = new LinkedList<String>();

    private static List<Integer> ansIndexList = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] params = buf.readLine().split(" ");

            if (params[0].equals("0") && params[1].equals("0")) {
                return;
            }

            // init
            ansSum = 0;
            ansList.clear();
            ansIndexList.clear();
            inputStr = params[1];
            maxLen = inputStr.length();
            targetNum = Integer.parseInt(params[0]);

            DFS (0);

            Collections.sort(ansList);
            if (ansList.size() == 0) {
                System.out.println("error");
            } else if (ansList.size() >= 2 && getSum(ansList.get(ansList.size() - 1)) == getSum(ansList.get(ansList.size() - 2))) {
                System.out.println("rejected");
            } else {
                System.out.println(ansSum + " " + ansStr);
            }
        }
    }

    public static void DFS(int dep) {
        // return
        if (dep >= (maxLen - 1)) {
            String tempStr = outputAns(inputStr);
            int tempSum = getSum(tempStr);
            if (tempSum <= targetNum) {
                if (ansSum <= tempSum) {
                    ansSum = tempSum;
                    ansStr = tempStr;
                    ansList.add(ansStr);
                }
            }
            return;
        }

        // two strategies
        DFS(dep + 1);

        ansIndexList.add(dep);
        DFS(dep + 1);
        ansIndexList.remove(ansIndexList.size() - 1);
    }

    public static String outputAns(String str) {
        if (ansIndexList.size() == 0) {
            return str;
        }

        int idx = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ansIndexList.size(); i++) {
            if (i == (ansIndexList.size() - 1)) {
                ans.append(str, idx, ansIndexList.get(i) + 1);
                idx = ansIndexList.get(i) + 1;
                if (idx < maxLen) {
                    ans.append(" ").append(str, idx, str.length());
                }
            } else {
                ans.append(str, idx, ansIndexList.get(i) + 1).append(" ");
                idx = ansIndexList.get(i) + 1;
            }
        }

        return ans.toString();
    }

    public static int getSum(String param) {
        if (param.length() <= 0) {
            return targetNum + 1;
        }

        int result = 0;
        String[] nums = param.split(" ");
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}
