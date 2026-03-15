package leetcode.Vol101to200;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int minGas = 0;
        int sumGas = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas = sumGas + (gas[i] - cost[i]);
            if (sumGas < minGas) {
                idx = i + 1;
                minGas = sumGas;
            }
        }

        return sumGas < 0 ? -1 : idx;
    }
}
