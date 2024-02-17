package algorithm_template;

public class IntBinarySearch {
    public int binarySearch_1(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (check()) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public int binarySearch_2(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check()) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    public boolean check() {
        return true;
    }
}
