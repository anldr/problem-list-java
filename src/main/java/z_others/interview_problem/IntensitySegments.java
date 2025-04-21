package z_others.interview_problem;

import java.util.*;

public class IntensitySegments {
    private final TreeMap<Integer, Integer> segments;

    public IntensitySegments() {
        this.segments = new TreeMap<>();
    }

    /**
     * add amount in range: [from,to)
     * method time complexity: O(n)
     * @param from range start
     * @param to range end,not include
     * @param amount amount
     */
    public void add(int from, int to, int amount) {
        commonProcess(from, to);

        // get all segments in [from,to)
        NavigableMap<Integer, Integer> subMap = this.segments.subMap(from, true, to, false);
        List<Integer> keys = new ArrayList<>(subMap.keySet());
        for (int key : keys) {
            this.segments.put(key, this.segments.get(key) + amount);
        }

        mergeSegments();
    }

    /**
     * set amount in range: [from->to)
     * method time complexity: O(logn)
     * @param from range start
     * @param to range end,not include
     * @param amount amount
     */
    public void set(int from, int to, int amount) {
        commonProcess(from, to);

        int endOriginalValue = segments.get(to);
        segments.subMap(from, true, to, false).clear();
        segments.put(from, amount);
        segments.put(to, endOriginalValue);

        mergeSegments();
    }

    /**
     * method time complexity: O(n), n is the number of segments.
     */
    @Override
    public String toString() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            result.add("[" + entry.getKey() + "," + entry.getValue() + "]");
        }

        return result.isEmpty() ? "[]" : "[" + String.join(",", result) + "]";
    }

    private void commonProcess(int from, int to) {
        if (checkParam(from, to)) {
            return ; // fromKey > toKey, do nothing
        }

        if (this.segments.isEmpty()) {
            this.segments.put(from, 0);
            this.segments.put(to, 0);
        }

        // split at 'from' point and 'to' point
        findAt(from);
        findAt(to);
    }

    private boolean checkParam(int from, int to) {
        return from >= to;
    }

    /**
     * find max key, which is less than or equal to
     * method time complexity: O(logn), n is the number of segments.
     * @param point key
     */
    private void findAt(int point) {
        Map.Entry<Integer, Integer> entry = this.segments.floorEntry(point);
        if (entry == null)  {
            this.segments.put(point, 0);
            return ;
        }

        int key = entry.getKey();
        int value = entry.getValue();

        if (key < point && !this.segments.containsKey(point)) {
            this.segments.put(point, value);
        }
    }

    /**
     * merge range
     */
    private void mergeSegments() {
        Integer prevKey = null;
        Integer prevValue = null;
        List<Integer> toRemove = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            if (prevKey == null && entry.getValue().equals(0)) {
                toRemove.add(entry.getKey());
                continue;
            }

            if (prevKey != null && entry.getValue().equals(prevValue)) {
                toRemove.add(entry.getKey());
            } else {
                prevKey = entry.getKey();
                prevValue = entry.getValue();
            }
        }

        for (Integer key : toRemove) {
            segments.remove(key);
        }
    }

    public static void main(String[] args) {
        // test case 1
        IntensitySegments s1 = new IntensitySegments();
        System.out.println(s1); // output: []
        s1.add(10, 30, 1);
        System.out.println(s1); // output: [[10,1],[30,0]]
        s1.add(20, 40, 1);
        System.out.println(s1); // output: [[10,1],[20,2],[30,1],[40,0]]
        s1.add(10, 40, -2);
        System.out.println(s1); // output: [[10,-1],[20,0],[30,-1],[40,0]]

        // test case 2
        IntensitySegments s2 = new IntensitySegments();
        System.out.println(s2); // output: []
        s2.add(10, 30, 1);
        System.out.println(s2); // output: [[10,1],[30,0]]
        s2.add(20, 40, 1);
        System.out.println(s2); // [[10,1],[20,2],[30,1],[40,0]]
        s2.add(10, 40, -1);
        System.out.println(s2); // [[20,1],[30,0]]
        s2.add(10, 40, -1);
        System.out.println(s2); // [[10,-1],[20,0],[30,-1],[40,0]]

        // test case 3
        IntensitySegments s3 = new IntensitySegments();
        System.out.println(s3); // output: []
        s3.add(10, 10, 1);
        System.out.println(s3); // output: []
        s3.add(10, 41, 1);
        System.out.println(s3); // output: [[10,1],[41,0]]
        s3.add(40, 50, 1);
        System.out.println(s3); // output: [[10,1],[40,2],[41,1],[50,0]]

        // test case 4
        IntensitySegments s4 = new IntensitySegments();
        System.out.println(s4); // output: []
        s4.add(-10, 10, 1);
        System.out.println(s4); // output: [[-10,1],[10,0]]
        s4.add(-5, 5, 1);
        System.out.println(s4); // output: [[-10,1],[-5,2],[5,1],[10,0]]
        s4.set(0, 100, 8);
        System.out.println(s4); // output: [[-10,1],[-5,2],[0,8],[100,0]]

        // test case 5
        IntensitySegments s5 = new IntensitySegments();
        System.out.println(s5); // output: []
        s5.set(-10, 10, 1);
        System.out.println(s5); // output: [[-10,1],[10,0]]
        s5.set(-5, 5, 2);
        System.out.println(s5); // output: [[-10,1],[-5,2],[5,1],[10,0]]
        s5.set(0, 100, 8);
        System.out.println(s5); // output: [[-10,1],[-5,2],[0,8],[100,0]]
    }
}
