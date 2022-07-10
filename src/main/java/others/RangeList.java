package others;

import java.util.LinkedList;
import java.util.List;

public class RangeList {
    List<Range> result = new LinkedList<>();

    public void add(int leftRange, int rightRange) {
        if (leftRange == rightRange) {
            return;
        }

        if (result.size() == 0) {
            result.add(new Range(leftRange, rightRange));
            return;
        }

        // insert to list
        boolean insertFlag = false;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).left >= leftRange) {
                result.add(i, new Range(leftRange, rightRange));
                insertFlag = true;
                break;
            }
        }

        if (!insertFlag) {
            result.add(new Range(leftRange, rightRange));
        }

        // merge range
        int newLeftRng = result.get(0).left;
        int newRightRng = result.get(0).right;
        List<Range> newRange = new LinkedList<>();
        for (Range r : result) {
            if (r.left > newRightRng) {
                newRange.add(new Range(newLeftRng, newRightRng));
                newLeftRng = r.left;
            }
            newRightRng = Math.max(newRightRng, r.right);
        }
        newRange.add(new Range(newLeftRng, newRightRng));

        result = newRange;
    }

    public void remove(int leftRange, int rightRange) {
        if (leftRange == rightRange || result.size() == 0) {
            return;
        }

        List<Range> newRange = new LinkedList<>();
        for (Range r : result) {
            if (r.left >= rightRange || r.right <= leftRange) {
                newRange.add(r);
            } else if (r.left > leftRange && r.right > rightRange) {
                newRange.add(new Range(rightRange, r.right));
            } else if (r.left < leftRange && rightRange < r.right) {
                newRange.add(new Range(r.left, leftRange));
                newRange.add(new Range(rightRange, r.right));
            } else if (r.left < leftRange && r.right < rightRange) {
                newRange.add(new Range(r.left, leftRange));
            } else if (r.left == leftRange) {
                newRange.add(new Range(rightRange, r.right));
            } else if (r.right == rightRange){
                newRange.add(new Range(r.left, leftRange));
            }
        }

        result = newRange;
    }

    public void print() {
        for (Range r : result) {
            System.out.print("[" + r.left + ", " + r.right + ") ");
        }
        System.out.println();
    }

    /*
        define range
     */
    class Range {
        int left;
        int right;

        Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        RangeList rngList = new RangeList();

        rngList.add(1, 5);
        rngList.print();

        rngList.add(10, 20);
        rngList.print();

        rngList.add(20, 20);
        rngList.print();

        rngList.add(20, 21);
        rngList.print();

        rngList.add(2, 4);
        rngList.print();

        rngList.add(3, 8);
        rngList.print();

        rngList.remove(10, 10);
        rngList.print();

        rngList.remove(10, 11);
        rngList.print();

        rngList.remove(15, 17);
        rngList.print();

        rngList.remove(3, 19);
        rngList.print();
    }
}
