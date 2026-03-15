package leetcode.Vol301to400;

import java.util.*;

public class LeetCode380 {
    private int curIdx;

    private int[] arrayNum;

    private Map<Integer, Integer> valMap;

    private Random rand;

    public LeetCode380() {
        this.curIdx = -1;
        this.rand = new Random();
        this.valMap = new HashMap<>();
        this.arrayNum = new int[200000 + 7];
    }

    public boolean insert(int val) {
        if (valMap.containsKey(val)) {
            return false;
        }

        arrayNum[++curIdx] = val;
        valMap.put(val, curIdx);
        return true;
    }

    public boolean remove(int val) {
        if (!valMap.containsKey(val)) {
            return false;
        }

        int idx = valMap.get(val);
        arrayNum[idx] = arrayNum[curIdx--];
        valMap.put(arrayNum[idx], idx);
        valMap.remove(val);
        return true;
    }

    public int getRandom() {
        int x = rand.nextInt(curIdx + 1);
        return arrayNum[x];
    }
}
